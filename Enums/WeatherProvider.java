package DZ7.Enums;

import java.io.IOException;

public interface WeatherProvider {
    void getWeather (Periods periods) throws IOException;


}
