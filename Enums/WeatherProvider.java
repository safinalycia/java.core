package DZ8.Enums;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherProvider {
    void getWeather (Periods periods) throws IOException, SQLException;


    void readWeatherDayFromDB(String selectedCity) throws IOException, SQLException;
}
