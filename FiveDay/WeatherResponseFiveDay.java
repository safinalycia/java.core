package DZ7.FiveDay;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

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
