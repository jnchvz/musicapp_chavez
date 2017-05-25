package upmc.musicapp.pojos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Release {
    private String title;
    private String id;
    private String date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static ArrayList<Release> releasesFromJSON(String releasesJSON) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Map<String, Object> mapResponse = mapper.readValue(releasesJSON, Map.class);
        String releasesRaw = mapper.writeValueAsString(mapResponse.get("releases"));

        ArrayList<Release> releases = mapper.readValue(releasesRaw, new TypeReference<ArrayList<Release>>() {});
        return releases;
    }

}
