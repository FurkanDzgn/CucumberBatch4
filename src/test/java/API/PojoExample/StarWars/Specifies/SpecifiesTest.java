package API.PojoExample.StarWars.Specifies;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecifiesTest {

    private static final String MAMMAL="mammal";
    private static final String ARTIFICIAL="artificial";
    private static final String SENTIENT="sentient";
    private static final String GASTROPOD="gastropod";
    private static final String REPTILE="reptile";
    private static final String AMPHIBIAN="amphibian";

    @Test
    public void species() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        // https://swapi.dev/api/species
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("swapi.dev").setPath("api/species");

        HttpGet httpGet =new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);

        ResponseBody parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(),ResponseBody.class);

        Map<String, List<String>> namesAndSpecies=new HashMap<>();
        List<String> mammal=new ArrayList<>();
        List<String> artificial=new ArrayList<>();
        List<String> sentient=new ArrayList<>();
        List<String> gastropod=new ArrayList<>();
        List<String> reptile=new ArrayList<>();
        List<String> amphibian=new ArrayList<>();

        for(Results prs:parsedObject.getResults()){
            if(prs.getClassification().equalsIgnoreCase(MAMMAL)){
                mammal.add(prs.getName());
            }
            else if(prs.getClassification().equalsIgnoreCase(ARTIFICIAL)){
                artificial.add(prs.getName());
            }
            else if(prs.getClassification().equalsIgnoreCase(SENTIENT)){
                sentient.add(prs.getName());
            }
            else if(prs.getClassification().equalsIgnoreCase(GASTROPOD)){
                gastropod.add(prs.getName());
            }
            else if(prs.getClassification().equalsIgnoreCase(REPTILE)){
                reptile.add(prs.getName());
            }
            else if(prs.getClassification().equalsIgnoreCase(AMPHIBIAN)){
                amphibian.add(prs.getName());
            }

        }

        namesAndSpecies.put(MAMMAL,mammal);
        namesAndSpecies.put(ARTIFICIAL,artificial);
        namesAndSpecies.put(SENTIENT,sentient);
        namesAndSpecies.put(GASTROPOD,gastropod);
        namesAndSpecies.put(REPTILE,reptile);
        namesAndSpecies.put(AMPHIBIAN,amphibian);
        System.out.println(namesAndSpecies);


    }
}
