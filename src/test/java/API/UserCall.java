package API;

import API.pojo.RegresPojo;
import API.pojo.UserPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class UserCall {

    @Test
    public void regresRequest() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        // . Specify URL/URI/endpoint
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/7");

        HttpGet httpGet =new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");


        HttpResponse httpResponse=httpClient.execute(httpGet);

        ObjectMapper objectMapper=new ObjectMapper();

        // PetPojo deserializedObject=objectMapper.readValue(httpResponse.getEntity().getContent(), PetPojo.class);

        UserPojo deserializedObject=objectMapper.readValue(httpResponse.getEntity().getContent(), UserPojo.class);

    //    RegresPojo deserializedObject=objectMapper.readValue(httpResponse.getEntity().getContent(), RegresPojo.class);

   //     System.out.println(deserializedObject.getData());

        System.out.println(deserializedObject.getData().getFirst_name());
        System.out.println(deserializedObject.getData().getLast_name());
        System.out.println(deserializedObject.getAd().getCompany());

    }
}
