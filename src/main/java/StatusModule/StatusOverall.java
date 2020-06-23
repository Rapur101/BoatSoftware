package StatusModule;

import com.google.gson.Gson;

public class StatusOverall {

    private boolean internetConnection;
    private boolean gpsSignal;
    private String location;


    private String formatToJson() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String getAsJson() {
        return formatToJson();
    }
}
