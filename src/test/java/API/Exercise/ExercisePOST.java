package API.Exercise;

import Utils.PayloadUtils;
import io.cucumber.java.en.Given;
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

public class ExercisePOST {

    @Given("the user enter id headers {string} ,{string} and {string} {string} name name {string} status {string}")
    public void the_user_enter_id_headers_and_name_name_status(String type, String tyep2, String value,
                                                               String id, String name, String status)
            throws URISyntaxException, IOException {
        // https://petstore.swagger.io/v2/pet/7891
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");

        HttpPost httpPost=new HttpPost(uriBuilder.build());

        httpPost.setHeader(type,value);
        httpPost.setHeader(tyep2,value);


        int idNum=Integer.parseInt(id);
        HttpEntity httpEntity=new StringEntity(PayloadUtils.getPetPayload(idNum,name,status));

        httpPost.setEntity(httpEntity);

        HttpResponse httpResponse=httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json", httpResponse.getEntity().getContentType().getValue());
        System.out.println(httpResponse.getStatusLine().getStatusCode());
    }
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
    public void PostRequestEx() throws URISyntaxException, IOException {
        HttpClient client=HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");

        HttpPost post=new HttpPost(uriBuilder.build());

        post.setHeader("Content-Type","application/json");
        post.setHeader("Content","application/json");

        HttpEntity entity=new StringEntity(PayloadUtils.getPetPayload(4569,"Marklow","available"));

        post.setEntity(entity);
        HttpResponse response=client.execute(post);
        System.out.println(response.getStatusLine().getStatusCode());
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
       Assert.assertEquals("application/json",response.getEntity().getContentType().getValue());
    }
}
