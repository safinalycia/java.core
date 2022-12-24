package DZ8.Enums;


import DZ8.Entity.WeatherData;
import DZ8.FiveDay.WeatherResponseFiveDay;
import DZ8.OneDay.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AccuWeatherProvider implements WeatherProvider {
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();
    private static final String DAILY = "daily";
    private static final String FIVE_DAY = "5day";

    WeatherResponseFiveDay weatherResponse5Day = new WeatherResponseFiveDay();

    WeatherResponse[] weatherResponse;

    WeatherData weatherData = new WeatherData(34, "Kazan", "21/12/2022", "ghtg", -4.0f);

    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";


    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:weather.db");
        return connection;
    }

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    //@Override
    public void getWeather(Periods periods) throws IOException, SQLException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            String jsonString = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponse[] weatherResponse = objectMapper.readValue(jsonString, WeatherResponse[].class);
            System.out.println(Arrays.toString(weatherResponse));

            try (Connection connection = getConnection();
                 PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
                saveWeather.setString(1, ApplicationGlobalState.getInstance().getSelectedCity());
                saveWeather.setString(2, weatherResponse[0].getLocalObservationDateTime());
                saveWeather.setString(3, weatherResponse[0].getWeatherText());
                saveWeather.setDouble(4, weatherResponse[0].temperature.metric.getValue());
                saveWeather.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } else if (periods.equals(Periods.FIVE_DAYS)) {
            String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(DAILY)
                    .addPathSegment(FIVE_DAY)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();
            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();

            String jsonString = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponseFiveDay weatherResponse5Day = objectMapper.readValue(jsonString, WeatherResponseFiveDay.class);
            System.out.println("В городе " + selectedCity + (weatherResponse5Day));

            try (Connection connection = getConnection();
                 PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
                for (int i = 0; i < 5; i++) {
                    saveWeather.setString(1, ApplicationGlobalState.getInstance().getSelectedCity());
                    saveWeather.setString(2, String.valueOf(weatherResponse5Day.dailyForCasts.get(0 +i).date));
                    saveWeather.setString(3, String.valueOf(weatherResponse5Day.dailyForCasts.get(0+ i).day.iconPhrase));
                    saveWeather.setString(4, String.valueOf(weatherResponse5Day.dailyForCasts.get(0+ i).temperature.minimum.getValue()));
                    saveWeather.execute();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void readWeatherDayFromDB(String selectedCity) throws SQLException {
        selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:weather.db");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weather WHERE city = '" + selectedCity + "'");
            ArrayList<WeatherResponse> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt(1) + " - " +
                                resultSet.getString(2) + " - " +
                                resultSet.getString(3) + " - " +
                                resultSet.getString(4) + " - " +
                                resultSet.getDouble(5) + " - "
                );
                arrayList.add(new WeatherResponse(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4)));
            }
            System.out.println(Arrays.toString(weatherResponse));
        }
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");
        String s = objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }
}