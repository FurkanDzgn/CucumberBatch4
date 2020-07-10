package API.PojoExample.StarWars.Specifies;

import java.util.List;

public class ResponseBody {
    private List<Results> results;

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
