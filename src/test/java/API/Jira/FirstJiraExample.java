package API.Jira;

import API.Jira.PojoJira.ResponseBodyJira;
import API.Jira.PojoJira.ResponseBodyJiraCreate;
import Utils.PayloadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Map;

public class FirstJiraExample {

    public static String nameValue;
    public static String valueValue;

    @Test
    public void JiraTest() throws URISyntaxException, IOException {
        // http://localhost:8080/rest/auth/1/session
        // Deserialize response body using POJO classes
        // Print out session.name, session.value

        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("http").setHost("localhost").setPort(8080).setPath("rest/auth/1/session");

        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-Type","application/json");

        HttpEntity httpEntity=new StringEntity(PayloadUtils.cookieAuthPayload());
        httpPost.setEntity(httpEntity);

        HttpResponse httpResponse=httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
        ObjectMapper objectMapper=new ObjectMapper();

//        // If we don't want to define all properties we use this method  // jackson.databind.exc.UnrecognizedPropertyException:
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//
//        // If MGLT(All of them upper case cause of them java not give result) but we use this configure and reach solution
//        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);

        ResponseBodyJira parsedObject =objectMapper.readValue(httpResponse.getEntity().getContent(),
                ResponseBodyJira.class);

         nameValue =parsedObject.getSession().getName();
         valueValue =parsedObject.getSession().getValue();

        System.out.println(parsedObject.getSession().getName());
        System.out.println(parsedObject.getSession().getValue());

    }

    @Test
    public void JiraTest2() throws URISyntaxException, IOException {

        // http://localhost:8080/rest/api/2/issue
        // Create 2 utility methods to get issue payload and generate JSESSION cookie
        // Print out newly created issue id, key, httplink
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();

        uriBuilder.setScheme("http").setHost("localhost").setPort(8080).setPath("rest/api/2/issue");

        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-Type","application/json");
//        httpPost.setHeader("Cookie",nameValue+"="+valueValue);
        httpPost.setHeader("Cookie",PayloadUtils.getJsessionCookie());
        System.out.println(nameValue+valueValue);

        HttpEntity httpEntity=new StringEntity(PayloadUtils.getJiraIssuePayload("Creating a bug from API",
                "Story created throuh API","Bug"));
        httpPost.setEntity(httpEntity);

        HttpResponse httpResponse=httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_CREATED,httpResponse.getStatusLine().getStatusCode());
        ObjectMapper objectMapper=new ObjectMapper();

//        ResponseBodyJiraCreate parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(),
//                ResponseBodyJiraCreate.class);
        Map<String,String> parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, String>>() {});

//        System.out.println(parsedObject.getId());
//        System.out.println(parsedObject.getKey());
//        System.out.println(parsedObject.getSelf());

        for(String pO:parsedObject.keySet()){
            System.out.printf("%s: %s\n",pO, parsedObject.get(pO));
        }


    }
}
