package API.Exercise;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExerciseDeserialization {

    @Test
    public void deserialization1() throws URISyntaxException, IOException {

        HttpClient httpClient= HttpClientBuilder.create().build();
        // https://api.chucknorris.io/jokes/random
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("api.chucknorris.io");
        uriBuilder.setPath("jokes/random");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json;charset=UTF-8",httpResponse.getEntity().getContentType().getValue());

        if(httpResponse.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String,Object> deserializedResponse=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});

        System.out.println(deserializedResponse.get("categories"));
        System.out.println(deserializedResponse.get("created_at"));
        System.out.println(deserializedResponse.get("icon_url"));
        System.out.println(deserializedResponse.get("id"));
        System.out.println(deserializedResponse.get("updated_at"));
        System.out.println(deserializedResponse.get("url"));
        System.out.println(deserializedResponse.get("value"));

    }

    @Test
    public void deserialization2() throws URISyntaxException, IOException {
        HttpClient httpClient=HttpClientBuilder.create().build();
        // http://tronalddump.io/random/quote
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("tronalddump.io");
        uriBuilder.setPath("random/quote");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        if(httpResponse.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }
        Assert.assertEquals("application/json",httpResponse.getEntity().getContentType().getValue());

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String,Object> deserailzedResponse=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});

        System.out.println(deserailzedResponse.get("appeared_at"));

        System.out.println(deserailzedResponse.get("tags"));

//        Object[] str=new Object[1];
//        str[0]=deserailzedResponse.get("tags");
//        System.out.println(Arrays.toString(str));
//        System.out.println(str[0]);

    //    Map<String,Object> map= (Map<String, Object>) deserailzedResponse.get("_links");
  //      System.out.println(map.get("self"));
        Map<String,Map<String,Map<String ,Object>>> map1= (Map<String, Map<String, Map<String, Object>>>) deserailzedResponse.get("_links");
       // System.out.println(map1.get("_links").get("self").get("href"));

        Map<String,Object> mapex= (Map<String, Object>) deserailzedResponse.get("_links");
        System.out.println(mapex.get("self"));
        Map<String,Object> mapEx2= (Map<String, Object>) mapex.get("self");
        System.out.println(mapEx2.get("href"));

//        Map<String,Object> mapEx2=

//        System.out.println(map1.get("self"));
//        System.out.println(map1.get("href"));
//        Set<String> set=map1.keySet();
//        System.out.println(set);
//        for(String s:set){
//            System.out.println(map1.get(s));
////            Set<String> set1=new HashSet<>();
////            set1=set;
//
//        }
    //    Map<String,Object> map2

    //    System.out.println(deserailzedResponse.get("_links"));


        Map<String,Object> map_embedded = (Map<String, Object>) deserailzedResponse.get("_embedded");
        System.out.println(map_embedded.get("author"));
        Map<String,Object[]> mapAuthor= (Map<String, Object[]>) deserailzedResponse.get("author");

   //     for(Object[] mp:mapAuthor.get()){

//        }
//        System.out.println(mapAuthor.get("author_id"));
//        Map<String,Object> array= (Map<String, Object>) deserailzedResponse.get("");
     //   Map<String,Object> mapAuthor2=;


    }
}
