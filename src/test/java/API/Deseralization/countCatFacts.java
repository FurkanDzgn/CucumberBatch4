package API.Deseralization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.it.Ma;
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
import java.sql.SQLOutput;
import java.util.*;

public class countCatFacts {

    @Test
    public void countCatFacts() throws URISyntaxException, IOException {

        HttpClient httpClient= HttpClientBuilder.create().build();
        // http://cat-fact.herokuapp.com/facts
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("cat-fact.herokuapp.com");
        uriBuilder.setPath("facts");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        if(httpResponse.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String, List> parsedResponse=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, List>>() {});

       System.out.println(parsedResponse);// --> I got all response
        System.out.println(parsedResponse.get("all").size());


        List<Map<String,Object>> user = (List<Map<String, Object>>) parsedResponse.get("all");

        Map<String,Map<String,Object>> first = (Map<String, Map<String, Object>>) user.get(0).get("user");
        System.out.println(first.get("name").get("first"));




    }

    @Test
    public void countCatFact() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        // http://cat-fact.herokuapp.com/facts
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("cat-fact.herokuapp.com");
        uriBuilder.setPath("facts");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        if(httpResponse.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String, List> parsedResponse=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, List>>() {});

        //   System.out.println(parsedResponse);// --> I got all response
        System.out.println(parsedResponse.get("all").size());

        // Find facts not about cats
        // Search for facts that do not contain car keyword in "testx" field.
        parsedResponse.get("all");
       List<Map<String,Object>> list=  parsedResponse.get("all");
        System.out.println(list.get(0).get("text"));
        int count=0;
        for(int i=0;i<list.size();i++){
            String task;
            task = (String) list.get(i).get("text");
            if(task.contains("cats")|| task.contains("cat")){
                count++;
            }
        }
        System.out.println(count);
        System.out.println(parsedResponse.get("all").size()-count);

    }

    @Test
    public void countCatFact2() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        // http://cat-fact.herokuapp.com/facts
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("cat-fact.herokuapp.com");
        uriBuilder.setPath("facts");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        if(httpResponse.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String, List<Map<String, Object>>> parsedResponse=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, List<Map<String, Object>>>>() {});

    //    System.out.println(parsedResponse);
  //      System.out.println(parsedResponse.get("all").get(0));
//       for(int i=0;i<parsedResponse.get("all").size();i++){
//           System.out.println(parsedResponse.get("all").get(i).get("text"));
//       }
        List<Map<String,Object>> mapList= parsedResponse.get("all"); // =>List
        for(Map<String,Object> mL:mapList){
      //      System.out.println(mL.get("text").toString());
            Map<String,Object> userInfo= (Map<String, Object>) mL.get("user");
            Map<String,String> firstNLastName= (Map<String, String>) userInfo.get("name");

            System.out.println(firstNLastName.get("first"));
            System.out.println(firstNLastName.get("last"));

       }


//       for( Map<String, Object> ss:parsedResponse.get("all")){
//           System.out.println(ss.get("text"));
//       }

    }

    @Test
    public void regresIn() throws URISyntaxException, IOException {
        HttpClient httpClient=HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        if(httpResponse.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String,Object> parsedResponse=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});

        System.out.println(Integer.parseInt(parsedResponse.get("page").toString()));
        System.out.println(parsedResponse.get("per_page"));
   //     System.out.println(parsedResponse.get("data"));

        List<Map<String,Object>> list= (List<Map<String, Object>>) parsedResponse.get("data");


        System.out.println(Integer.parseInt(list.get(0).get("id").toString()));
        System.out.println(list.get(0).get("email"));
        System.out.println(list.get(0).get("first_name"));
        System.out.println(list.size());

        Assert.assertEquals(Integer.parseInt(parsedResponse.get("per_page").toString()),list.size());

        for(Map<String,Object> ll:list){
            System.out.print(ll.get("first_name")+"-");
        }
        System.out.println();

        for(int i=0;i<list.size();i++){

            System.out.print(list.get(i).get("first_name")+"-");
        }

//        Set<String> set=parsedResponse.keySet();
//        System.out.println(set);
//        for(String s:set){
//            parsedResponse.get(s);
//        }
    }

    @Test
    public void GOT() throws URISyntaxException, IOException {
        HttpClient httpClient=HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.got.show").setPath("api/map/characters");



        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String,Object> parsedResponse=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String,Object>>() {});

        parsedResponse.get("techtorial");

         List<Map<String,Object>> dataValues= (List<Map<String, Object>>) parsedResponse.get("data");
         Map<String,Object> firstHouse = dataValues.get(0);
    //     System.out.println(firstHouse.get("house"));
         Set<String> set=new HashSet<>();
         for(Map<String,Object> dt:dataValues){
//             System.out.println(dt.get("house"));
             set.add((String) dt.get("house"));
         }
        System.out.println(set);
        System.out.println(set.size());

    }

    @Test
    public void verify() throws URISyntaxException, IOException {
        HttpClient httpClient=HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users").setCustomQuery("per_page=12");



        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String,Object> parsed=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        List<Map<String,Object>> map= (List<Map<String, Object>>) parsed.get("data");

        System.out.println(map.size());
        Assert.assertEquals(parsed.get("per_page"),map.size());
        int num=0;
        for(int i=0;i<map.size();i++){
            num+= (int) map.get(i).get("id");
        }
        System.out.println(num);

    }

    @Test
    public void itunes() throws URISyntaxException, IOException {
        HttpClient httpClient=HttpClientBuilder.create().build();
        int limitValue=100;
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("itunes.apple.com").setPath("search").setCustomQuery("term=linkinpark&limit="+limitValue);
        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
        HttpResponse httpResponse=httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String,Object> parsed = objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});
        List<Map<String,Object>>artistNmae= (List<Map<String, Object>>) parsed.get("results");
        Assert.assertEquals(parsed.get("resultCount"),artistNmae.size());
        Assert.assertEquals(limitValue,parsed.get("resultCount"));
        for(Map<String,Object> mm:artistNmae){
            Assert.assertTrue(String.valueOf(mm.get("artistName")).contains("LINKIN PARK") ||
                    String.valueOf(mm.get("artistName")).contains("Linkin Park"));
        }




    }


}
