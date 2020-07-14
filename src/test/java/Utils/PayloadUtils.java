package Utils;

import API.Jira.PojoJira.ResponseBodyJira;
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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadUtils { // requestBody == Payload

    public static String getPetPayload(int id, String name, String status){
        return "{\n" +
                "  \"id\": "+id+",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \""+status+"\"\n" +
                "}";
    }

    public static String putMethod(String name,String job){
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }

    public static String generateStringFromResource(String path) throws IOException {

        String petPayload=new String(Files.readAllBytes(Paths.get(path)));
        return petPayload;
    }

    public static String cookieAuthPayload(){
        return "{\n" +
                "    \"username\":\"furkan.duzgun\",\n" +
                "    \"password\":\"VwMGkY2#cD6Xdct\"\n" +
                "}";
    }

    public static String getJiraIssuePayload(String summary,String description,String issuetype){
        return "{\n" +
                "    \"fields\":{\n" +
                "        \"project\":{\n" +
                "            \"key\":\"TEC\"\n" +
                "        },\n" +
                "        \"summary\":\""+summary+"\",\n" +
                "        \"description\":\""+description+"\",\n" +
                "        \"issuetype\":{\n" +
                "            \"name\":\""+issuetype+"\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

    public static String getJsessionCookie() throws URISyntaxException, IOException {
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

        ResponseBodyJira parsedObject =objectMapper.readValue(httpResponse.getEntity().getContent(),
                ResponseBodyJira.class);

//        System.out.println(parsedObject.getSession().getName());
//        System.out.println(parsedObject.getSession().getValue());

        String cookieName=parsedObject.getSession().getName();
        String cookieValue=parsedObject.getSession().getValue();

        return String.format("%s=%s",cookieName,cookieValue);
    }

    public static String getPayloadCreatePet(String name,String status,String url){
        return "{\n" +
                "  \"name\":\""+name+"\",\n" +
                "  \"age\":3,\n" +
                "  \"status\":\""+status+"\",\n" +
                "  \"id\":45345,\n" +
                "  \"photoUrl\":\""+url+"\"\n" +
                "}";
    }
}
