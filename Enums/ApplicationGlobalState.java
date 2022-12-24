package DZ8.Enums;

public class ApplicationGlobalState {
    private static ApplicationGlobalState INSTANCE;

    private String selectedCity = null;

    private final String API_KEY = "fznZAIqxXoFXThyJQVb59Qh09qlBdVHs";

    private final String DB_FILENAME = "weather.db";

    private ApplicationGlobalState() {
    }

    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }
    public String getApiKey() {
        return this.API_KEY;
    }

    public String getDbFileName() {
        return null;
    }

    //public String getDbFileName() {
    //}
}
