package API;

import API.pojo.PetPojo;
import API.pojo.RegresPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.openqa.selenium.json.JsonOutput;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class PetRequest {

    @Test
    public void petReq() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        // . Specify URL/URI/endpoint
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/12");

        HttpGet httpGet =new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");


        HttpResponse httpResponse=httpClient.execute(httpGet);

        ObjectMapper objectMapper=new ObjectMapper();

        PetPojo deserializedObject=objectMapper.readValue(httpResponse.getEntity().getContent(), PetPojo.class);

        System.out.println(deserializedObject.getId());
        System.out.println(deserializedObject.getName());
    }


}
