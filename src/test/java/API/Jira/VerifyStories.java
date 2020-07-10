package API.Jira;

import Utils.PayloadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.json.Json;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VerifyStories {

    HttpClient httpClient;
    URIBuilder uriBuilder;
    HttpGet httpGet;
    HttpResponse httpResponse;
    ObjectMapper objectMapper=new ObjectMapper();

    @Before
    public void setUp() throws URISyntaxException, IOException {
        httpClient= HttpClientBuilder.create().build();
        uriBuilder=new URIBuilder();
        // http://localhost:8080/rest/api/2/search?jql=assignee=jack&maxResults=6
        uriBuilder.setScheme("http").setHost("localhost").setPort(8080)
                .setPath("rest/api/2/search").setCustomQuery("jql=assignee=furkan.duzgun&maxResults=2");

    }

    @Test
    public void maxResults() throws URISyntaxException, IOException {
        httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
        httpGet.setHeader("Content-Type","application/json");
        httpGet.setHeader("Cookie", PayloadUtils.getJsessionCookie());

        httpResponse=httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
        Assert.assertTrue(httpResponse.getEntity().getContentType().getValue().contains("application/json"));

        Map<String,Object> parsedObjects=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

   //     System.out.println(parsedObjects.get("maxResults"));
        List<Map<String,Object>> issuesList= (List<Map<String, Object>>) parsedObjects.get("issues");
 //       System.out.println(issues.size());
        Assert.assertEquals(issuesList.size(),parsedObjects.get("maxResults"));
        System.out.println(issuesList.size());
        System.out.println(parsedObjects.get("total"));

        Set<String> issueKeys = new HashSet<>();

        for (Map<String,Object> map:issuesList) {
        //    issueKeys.add(map.get("key").toString());
            issueKeys.add((String) map.get("key"));
        }
        Assert.assertEquals(2,issueKeys.size());

    }

    @Test
    public void advDeser() throws URISyntaxException, IOException {
        httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
        httpGet.setHeader("Content-Type","application/json");
        httpGet.setHeader("Cookie", PayloadUtils.getJsessionCookie());

        httpResponse=httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        JsonNode parsedResp=objectMapper.readTree(httpResponse.getEntity().getContent());
   //     System.out.println(parsedResp.get());

        System.out.println(parsedResp.get("total"));
        JsonNode issues = parsedResp.get("issues");
        System.out.println(parsedResp.get("issues").get(0).get("self").asText()); // remove the double qoutes
        System.out.println(issues.get(0).get("self"));

//        for(JsonNode issue:issues){
//            System.out.println(issue.get("self").asText());
//        }
//
//        System.out.println(issues.get(0).get("fields").get("issuetype").get("id"));
//
//        JsonNode fields= issues.get(0).get("fields");
//        JsonNode issuetype= fields.get("issuetype");
//        System.out.println(issuetype.get("self"));

        for(JsonNode issue:issues){
            JsonNode field= issue.get("fields");
            JsonNode issuetyp= field.get("issuetype");
            System.out.println(issuetyp.get("self"));
        }






    }

}
