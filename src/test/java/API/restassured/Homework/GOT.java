package API.restassured.Homework;

import API.restassured.Homework.PojoTry.ResponseBodyGOT;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static io.restassured.RestAssured.given;

public class GOT {

    @Test
    public void got(){

        // given().header("contentType",ContentType.JSON).header("accept",ContentType.JSON)
        //        .when().get("https://swapi.dev/api/planets/1").then().statusCode(200).and().contentType(ContentType.JSON);

       Map<String,Object> responseBody= given().header("accept", ContentType.JSON)
                .when().get("https://api.got.show/api/map/characters").getBody().as(new TypeRef<Map<String, Object>>() {
               });
        List<Map<String,Object>> data= (List<Map<String, Object>>) responseBody.get("data");

        Map<String,String> map=new LinkedHashMap<>();
        Set<Object> house=new HashSet<>();
        List<Object> houseList=new ArrayList<>();


//            for(int i=0;i<data.size();i++) {
//            //    if(!data.get(i).get("house").toString().equalsIgnoreCase("null".toString())){
//                if(data.get(i).get("house")!=null){
//               //     house.add(data.get(i).get("house").toString());
//                    houseList.add(data.get(i).get("house"));
//                    house.add(data.get(i).get("house"));
//                }
//            }
            // If There is no key value What step I follow

//        System.out.println(house);
//        System.out.println(houseList);

        for(int i=0;i<data.size();i++){
            if(data.get(i).get("house")!=null && data.get(i).get("_id")!=null) {

                if (map.containsKey(data.get(i).get("house").toString())) {
                    String str = map.get(data.get(i).get("house").toString());

                    map.replace(data.get(i).get("house").toString(), str + "<->" + (String) data.get(i).get("_id"));
                } else {
                    map.put(data.get(i).get("house").toString(), (String) data.get(i).get("_id"));
                }

            }
        }
        System.out.println(map);
        System.out.println(map.size());


    }

    @Test
    public void gotHttpClient() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.got.show").setPath("api/map/characters");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);
        if(httpResponse.getStatusLine().getStatusCode()!=200){
            Assert.fail();
        }
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        ResponseBodyGOT parsedPojo=objectMapper.readValue(httpResponse.getEntity().getContent(),
                ResponseBodyGOT.class);
        Map<String,Object> map=new LinkedHashMap<>();
        for(int i=0;i<parsedPojo.getData().size();i++){
            map.put(parsedPojo.getData().get(i).get_id(),parsedPojo.getData().get(i).getHouse());
        }
        System.out.println(map);


    }
}
