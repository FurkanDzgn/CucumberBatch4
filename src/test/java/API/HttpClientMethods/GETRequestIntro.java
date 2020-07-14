package API.HttpClientMethods;

import io.cucumber.java.bs.A;
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
import java.util.Arrays;

public class GETRequestIntro {

    @Test
    public void getRequest() throws URISyntaxException, IOException {

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

        // Open a client
        HttpClient client= HttpClientBuilder.create().build();

        // Specify URL/URI/endpoint
        // https://petstore.swagger.io/v2/pet/{petID}
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/7891");

        // Specify the HTTP method (GET, POST)
        HttpGet get =new HttpGet(uriBuilder.build());  // we declaered

        // Add header parameters(content-type, accept)
        get.setHeader("Accept","application/json");

        // Execute (click on Send button)
       HttpResponse response= client.execute(get); // we decleared


        Assert.assertEquals(200,response.getStatusLine().getStatusCode());
        System.out.println("Status code for GET request is: "+response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getProtocolVersion());
        System.out.println(response.getStatusLine().getReasonPhrase());

        Assert.assertEquals("application/json", response.getEntity().getContentType().getValue());
        // request ->


    }

    @Test
    public void getRequest2() throws URISyntaxException, IOException {
        // execute a GET request to:
        // https://petstore.swagger.io/v2/pet/findByStatus?status=sold

        HttpClient client= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/findByStatus");
        uriBuilder.setCustomQuery("status=sold");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse response=client.execute(httpGet);

        Assert.assertEquals(200,response.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json", response.getEntity().getContentType().getValue());



    }



    @Test
    public void getRequest3() throws URISyntaxException, IOException {
        HttpClient client=HttpClientBuilder.create().build();

        URIBuilder builder=new URIBuilder();
        builder.setScheme("https");
        builder.setHost("petstore.swagger.io");
        builder.setPath("v2/pet/7891");

        HttpGet httpGet=new HttpGet(builder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse response=client.execute(httpGet);

        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getProtocolVersion());
        System.out.println(response.getStatusLine().getReasonPhrase());

        System.out.println(response.getEntity().getContentType().getValue());

    }

    @Test
    public void exercise() throws URISyntaxException, IOException {
        HttpClient httpClient=HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/1");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json",httpResponse.getEntity().getContentType().getValue());

    }

























}
