package API.PojoExample.CatFacts;

import java.util.List;

public class ResponseBodyCatFact {

    private List<All> all;

    public List<All> getAll() {
        return all;
    }

    public void setAll(List<All> all) {
        this.all = all;
    }
}
