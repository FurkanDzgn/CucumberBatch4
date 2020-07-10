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

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VerifyUserHomework {

    HttpClient httpClient;
    URIBuilder uriBuilder;
    ObjectMapper objectMapper=new ObjectMapper();
    @Before
    public void setUp(){
        httpClient= HttpClientBuilder.create().build();
        uriBuilder=new URIBuilder();
        uriBuilder.setScheme("http").setHost("localhost").setPort(8080).setPath("rest/api/2/search")
                .setCustomQuery("?jql=assignee=alise");
    }

    @Test
    public void verify() throws URISyntaxException, IOException {

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
        httpGet.setHeader("Content-Type","application/json");
        httpGet.setHeader("Cookie", PayloadUtils.getJsessionCookie());
        HttpResponse httpResponse=httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

//        Map<String,Object> parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(),
//                new TypeReference<Map<String, Object>>() {});
//
//        System.out.println(parsedObject.get("total"));
//        List<Map<String,Object>> issueList= (List<Map<String, Object>>) parsedObject.get("issues");
//        System.out.println(issueList.size());
//
//        Set<String> set=new HashSet<>();
//        for(Map<String,Object> iss:issueList){
//            set.add(iss.get("key").toString());
//        }
//        Assert.assertEquals(parsedObject.get("total"),issueList.size());
//        Assert.assertEquals(parsedObject.get("total"),set.size());
//        System.out.println(parsedObject.get("total"));

        JsonNode jsonNode=objectMapper.readTree(httpResponse.getEntity().getContent());
//        System.out.println(jsonNode.get("total"));
//        System.out.println(jsonNode.get("maxResults"));

        JsonNode jsonNode1=jsonNode.get("issues");
        Set<JsonNode> nameKey=new HashSet<>();

        for(int i=0;i<jsonNode1.size();i++){
            nameKey.add(jsonNode1.get(i).get("key"));
        }

        System.out.println(nameKey);
        System.out.println(jsonNode.get("total"));
        System.out.println(nameKey.size());
   //     Assert.assertEquals(jsonNode.get("total"),nameKey.size());


    }
}
