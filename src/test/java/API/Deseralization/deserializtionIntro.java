package API.Deseralization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class deserializtionIntro {

    @Test
    public void deserialization1() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/1");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse response=client.execute(httpGet);

        if(response.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String, Object> deserializedResponse=objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});

        System.out.println("The id from response body is:"+deserializedResponse.get("id"));
        System.out.println(deserializedResponse.get("category"));
        System.out.println(deserializedResponse.get("name"));
        System.out.println(deserializedResponse.get("tags"));
        System.out.println(deserializedResponse.get("status"));

        Map<String,Object> category = (Map<String, Object>) deserializedResponse.get("category");
        System.out.println("category id is:"+category.get("id"));
        System.out.println("category name is: "+category.get("name"));

//        Map<String,Object[]> tags= (Map<String, Object[]>) deserializedResponse.get("tags");
//        System.out.println(tags.get(0));
    }

    @Test
    public void deserialization2() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/2");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse response=client.execute(httpGet);

        if(response.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String, Object> deserializedResponse=objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});

        Map<String,Object> ad= (Map<String, Object>) deserializedResponse.get("ad");

        System.out.println(ad.get("company"));
        System.out.println(ad.get("url"));
        System.out.println(ad.get("text"));
    }

}
