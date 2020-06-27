package API.Exercise;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class ExerciseGET {

    @Test
    public void getRequestEx() throws URISyntaxException, IOException {

        // https://itunes.apple.com/search?term=linkinpark

        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("itunes.apple.com");
        uriBuilder.setPath("search");
        uriBuilder.setCustomQuery("term=linkinpark");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        Assert.assertEquals(200,httpResponse.getStatusLine().getStatusCode());
        Assert.assertEquals("OK",httpResponse.getStatusLine().getReasonPhrase());
    //    System.out.println(httpResponse.getStatusLine().getReasonPhrase());
    //    System.out.println(httpResponse.getStatusLine().getProtocolVersion());
        Assert.assertEquals("application/json",httpResponse.getEntity().getContentType().getValue());

    }

    @Test
    public void getRequest2() throws URISyntaxException, IOException {
        HttpClient httpClient=HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("itunes.apple.com");
        uriBuilder.setPath("search");
        uriBuilder.setCustomQuery("Adele");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");
        HttpResponse httpResponse=httpClient.execute(httpGet);

        Assert.assertEquals(200,httpResponse.getStatusLine().getStatusCode());
        Assert.assertEquals("OK",httpResponse.getStatusLine().getReasonPhrase());
        //    System.out.println(httpResponse.getStatusLine().getReasonPhrase());
        //    System.out.println(httpResponse.getStatusLine().getProtocolVersion());
        Assert.assertEquals("application/json",httpResponse.getEntity().getContentType().getValue());
    }
}
