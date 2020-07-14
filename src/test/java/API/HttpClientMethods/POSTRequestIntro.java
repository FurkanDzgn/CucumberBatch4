package API.HttpClientMethods;

import Utils.PayloadUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import static Utils.PayloadUtils.getPetPayload;

public class POSTRequestIntro {

      /*
     To send a API call:
    1. Open a client (POSTMAN, terminal)
    2. Specify URL/URI/endpoint
    3. Specify the HTTP method (GET, POST)
    4. Add query parameter( if needed)
    5. Add header parameters(content-type, accept)
    6. Add body parameter (for POST)
    7. Execute (click on Send button)
         */

    @Test
    public void postRequest() throws URISyntaxException, IOException {

        // https://reqres.in/api/users
     //   1. Open a client (POSTMAN, terminal)
        HttpClient httpClient= HttpClientBuilder.create().build();
        // . Specify URL/URI/endpoint
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users");


        //  3. Specify the HTTP method (GET, POST)
        HttpPost httpPost=new HttpPost(uriBuilder.build());
        //   5. Add header parameters(content-type, accept)
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("Accept","application/json");

        // 6. Add body parameter (for POST)
        HttpEntity entityBuilder=new StringEntity("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");
        httpPost.setEntity(entityBuilder);

        HttpResponse response=httpClient.execute(httpPost);

    //    Assert.assertEquals(201,response.getStatusLine().getStatusCode());
        Assert.assertEquals(HttpStatus.SC_CREATED,response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().toString().contains("application/json"));

    }

    @Test
    public void createPet() throws URISyntaxException, IOException {

        // https://petstore.swagger.io/v2/pet
        HttpClient httpClient=HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");


        HttpPost httpPost=new HttpPost(uriBuilder.build());

        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("Accept","application/json");

        HttpEntity httpEntity=new StringEntity(getPetPayload(5668,"Hatiko","waiting"));

        httpPost.setEntity(httpEntity);

        HttpResponse httpResponse=httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

    }
}
