package API.Deseralization;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StarWarsDeseralization {

    @Test
    public void getPlanets() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        // https://swapi.dev/api/planets
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("swapi.dev").setPath("api/planets");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String,Object> parsedMap=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        List<Map<String,Object>> list1= (List<Map<String, Object>>) parsedMap.get("results");

        Map<String,Object> planetsPopulationMap=new HashMap<>();
        Object population=0l; // Long
        for(Map<String,Object> ll:list1){
            try{
                population=Long.parseLong((ll.get("population").toString()));
            }catch (NumberFormatException ex){
                System.out.println("Population value was not numeric"+ex);
        //        planetsPopulationMap.put((String) ll.get("name"),null);
                population = ll.get("population");
            }
            planetsPopulationMap.put((String) ll.get("name"),population);
            //        Object population1=ll.get("population");
           //        planetsPopulationMap.put((String) ll.get("name"),population);
        }

        System.out.println(planetsPopulationMap);

        List<String> list2= (List<String>) list1.get(0).get("residents");

        for(String ls:list2){
    //        System.out.println(ls);
        }


    }

    @Test
    public void getPlanets2() throws URISyntaxException, IOException {

        HttpClient httpClient=HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("swapi.dev").setPath("api/planets");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        if(httpResponse.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
            Assert.fail();
        }
        ObjectMapper objectMapper=new ObjectMapper();

        Map<String,Object> parsedResponse=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});

       List<Map<String,Object>> results = (List<Map<String, Object>>) parsedResponse.get("results");
     List<String> films = (List<String>) results.get(0).get("films");

   //     System.out.println(films.get(0));

        for(Map<String,Object> result:results){
            List<String> fil = (List<String>) result.get("films");
            System.out.println(fil.get(0));
        }


    }


























}
