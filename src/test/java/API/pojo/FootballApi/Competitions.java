package API.pojo.FootballApi;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class Competitions {

    private int id;
    private Area area;
    private String name;
    private String code;
    private String emblemUrl;
    private String plan;
    private Map<String,Object> currentSeason;
    private int numberOfAvailableSeasons;
    private String lastUpdated;
}
