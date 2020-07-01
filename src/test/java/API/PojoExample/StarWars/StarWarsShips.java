package API.PojoExample.StarWars;

import com.fasterxml.jackson.databind.DeserializationFeature;
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
import java.util.List;

public class StarWarsShips {

    @Test
    public void ships() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("swapi.dev").setPath("api/starships");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // jackson.databind.exc.UnrecognizedPropertyException:

        ResponseBodyStarWars parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(), ResponseBodyStarWars.class);

        System.out.println(parsedObject.getCount());
      //  System.out.println(parsedObject.getResults().get(0).getName());
         List<Results> res=parsedObject.getResults();
        for(Results ll:res){
            System.out.println(ll.getModel());
        }
    }
}
