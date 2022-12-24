package DZ8.FiveDay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherResponseFiveDay {
    @JsonProperty("Headline")
    public Headline headline;
    @JsonProperty("DailyForeCasts")
    public ArrayList<DailyForCast> dailyForCasts;

    public WeatherResponseFiveDay(String string, String string1, String string2, double aDouble) {
    }

    public WeatherResponseFiveDay() {
    }

    public String toString() {
        return " " + dailyForCasts;
    }




}
