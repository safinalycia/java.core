package DZ8.Enums;

import java.io.IOException;
import java.sql.SQLException;

public class WeatherMain {
    public static void main(String[] args) throws SQLException, IOException {

        DatabaseRepositorySQLitelmpl databaseRepositorySQLite = new DatabaseRepositorySQLitelmpl();
        AccuWeatherProvider accuWeatherProvider = new AccuWeatherProvider();

        databaseRepositorySQLite.getConnection();
        databaseRepositorySQLite.createTableIfNotExists();

        UserInterface userInterface = new UserInterface();
        userInterface.runApplication();

        accuWeatherProvider.readWeatherDayFromDB(accuWeatherProvider.detectCityKey());
    }
}
