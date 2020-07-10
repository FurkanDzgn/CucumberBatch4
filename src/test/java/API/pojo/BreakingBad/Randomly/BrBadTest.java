package API.pojo.BreakingBad.Randomly;

import API.pojo.BreakingBad.Specific.BreakingBadSpecific;
import com.fasterxml.jackson.core.type.TypeReference;
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
import java.util.List;
import java.util.Random;

public class BrBadTest {

    public Random random=new Random();

    @Test
    public void brBad() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        // https://breakingbadapi.com/api/characters/12
        uriBuilder.setScheme("https").setHost("breakingbadapi.com").setPath("api/characters/"+random.nextInt(58));

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();
        // If we don't want to define all properties we use this method  // jackson.databind.exc.UnrecognizedPropertyException:
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        // If MGLT(All of them upper case cause of them java not give result) but we use this configure and reach solution
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);

//        List<BrBad> parsedObject= objectMapper.readValue(httpResponse.getEntity().getContent(), new TypeReference<List<BrBad>>() {
//        });
        List<BrBad> parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, BrBad.class));

        System.out.println(parsedObject.get(0).getName() +"\n"+parsedObject.get(0).getChar_id());

    }
}
