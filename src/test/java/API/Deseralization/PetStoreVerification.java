package API.Deseralization;

import Utils.Driver;
import Utils.PayloadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
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
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class PetStoreVerification {

    @Test
    public void verify() throws URISyntaxException, IOException {
        System.out.println("Constructing Request");
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");

       // uriBuilder.setPath("/good/location"); if we do like that overwrite happen

        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-Type","application/json");
        int num=17789;
        String name="Kumar";
        String status="available";

        System.out.println("Building request body");
        HttpEntity httpEntity=new StringEntity(PayloadUtils.getPetPayload(num,name,status));
        httpPost.setEntity(httpEntity);

        System.out.println("Started POST method execution");
        HttpResponse httpResponse=httpClient.execute(httpPost);

        System.out.println("Finished Post method execution");
        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
        System.out.println("mapping response body with Java Object");
        ObjectMapper objectMapper=new ObjectMapper();

        Map<String ,Object> parsedResponse=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});
        int actualID= (int) parsedResponse.get("id");
        String actualName= (String) parsedResponse.get("name");
        String actualStatus= (String) parsedResponse.get("status");

        Assert.assertEquals(num,parsedResponse.get("id"));
        Assert.assertEquals(name,parsedResponse.get("name"));
        Assert.assertEquals(status,parsedResponse.get("status"));
        List<Map<String,Object>> listTags= (List<Map<String, Object>>) parsedResponse.get("tags");
        System.out.println(listTags.get(0).get("name"));

        // Get Request to https://petstore.swagger.io/v2/pet/17789
        // Verify name, id ,status from response body

        uriBuilder.setPath("v2/pet/"+num);
        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
        System.out.println("Statrted executing Get request");
        httpResponse=httpClient.execute(httpGet);
        System.out.println("Finished executing Get request");
        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json",httpResponse.getEntity().getContentType().getValue());

        System.out.println("Deserializing response");
        parsedResponse=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});
        Assert.assertEquals(num,parsedResponse.get("id"));
        Assert.assertEquals(name,parsedResponse.get("name"));
        Assert.assertEquals(status,parsedResponse.get("status"));





    }
}
