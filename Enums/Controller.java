package DZ7.Enums;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    WeatherProvider weatherProvider = (WeatherProvider) new AccuWeatherProvider();

    Map<Integer, Functionality> variantResult = new HashMap();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(3, Functionality.GET_CUSTOM_WEATHER);
    }

    public void onUserInput(String input) throws IOException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }
        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeathet();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherInNext5Days();
                break;
            case GET_CUSTOM_WEATHER:
                getCustomWeather();
                break;
        }
    }

    private void getCurrentWeathet() {
    }

    public void getCurrentWeather() throws IOException {
            weatherProvider.getWeather(Periods.NOW);
        }

        public void getWeatherInNext5Days() throws IOException {
            weatherProvider.getWeather(Periods.FIVE_DAYS);
        }

        public void getCustomWeather() throws IOException {
            weatherProvider.getWeather(Periods.CUSTOM);
        }
}
