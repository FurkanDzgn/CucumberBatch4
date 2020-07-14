package API.HttpClientMethods;

import Utils.PayloadUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class PUTRequestIntro {

    @Test
    public void updateUser() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/2");

        HttpPut httpPut=new HttpPut(uriBuilder.build());
        httpPut.setHeader("Content-Type","application/json");
        httpPut.setHeader("Accept","application/json");

//        HttpEntity httpEntity=new StringEntity("{\n" +
//                "    \"name\": \"morpheus\",\n" +
//                "    \"job\": \"SDET\"\n" +
//                "}");
        HttpEntity httpEntity=new StringEntity(PayloadUtils.putMethod("morpheus","SDET"));

        httpPut.setEntity(httpEntity);

        HttpResponse response=httpClient.execute(httpPut);

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

    }
}
