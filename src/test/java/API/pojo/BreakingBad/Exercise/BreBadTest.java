package API.pojo.BreakingBad.Exercise;

import API.pojo.BreakingBad.Randomly.BrBad;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Map;

public class BreBadTest {
    HttpClient httpClient;
    URIBuilder uriBuilder;
    HttpGet httpGet;
    HttpResponse httpResponse;
    ObjectMapper objectMapper;
    @Before
    public void setUp() throws URISyntaxException, IOException {
        httpClient= HttpClientBuilder.create().build();
        uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("breakingbadapi.com").setPath("api/characters");

        httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        httpResponse=httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);

    }

    @Test
    public void deserialized1() throws URISyntaxException, IOException {

        List<Map<String,Object>> parsedObject = objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<List<Map<String, Object>>>() {});

        System.out.println(parsedObject.get(0).get("char_id"));

       List<String> occupation= (List<String>) parsedObject.get(0).get("occupation");
        System.out.println(occupation.get(0));
    }

    @Test
    public void deserialized2() throws IOException {

        List<ResponseBodyExercise> parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<List<ResponseBodyExercise>>() {});

//        List<BrBad> parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(),
//                objectMapper.getTypeFactory().constructCollectionType(List.class, BrBad.class));

        System.out.println(parsedObject.get(1).getImg());
    }

    @Test
    public void deserialized3() throws IOException {

        JsonNode parsedObject = objectMapper.readTree(httpResponse.getEntity().getContent());

        System.out.println(parsedObject.get(44).get("occupation").get(0));
    }

}
