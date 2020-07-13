package API.pojo.FootballApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class ResponseBodyFootball {

    private int count;
    private Object filters;
    private List<Competitions> competitions;
}
