package API.PojoExample.GOT;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.json.JsonOutput;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class GOTTest {

    private static final String THE_ROGUE_PRINCE ="The Rogue Prince";
    private static final String A_CLASH_OF_KINGS ="A Clash of Kings";
    private static final String A_STORM_OF_SWORDS ="A Storm of Swords";
    private static final String A_FEAST_FOR_CROWS ="A Feast for Crows";
    private static final String A_GAME_OF_THRONES ="A Game of Thrones";
    private static final String THE_WINDS_OF_WINTER ="The Winds of Winter";
    private static final String DANCE_WITH_DRAGONS_THE_WINDS_OF_WINTER = " Dance with Dragons  The Winds of Winter";


    @Test
    public void GOT_Male_Female() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
         // https://api.got.show/api/map/characters
        uriBuilder.setScheme("https").setHost("api.got.show").setPath("api/map/characters");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();
        // If we don't want to define all properties we use this method  // jackson.databind.exc.UnrecognizedPropertyException:
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        // If MGLT(All of them upper case cause of them java not give result) but we use this configure and reach solution
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
        ResponseBodyGOT parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(),ResponseBodyGOT.class);

        Map<String,Boolean> charName=new HashMap<>();
        int countMale=0;
        int countFemale=0;
        int countUnknown=0;

        for(int i=0;i<parsedObject.getData().size();i++){
            if(parsedObject.getData().get(i).getMale()==true){
                charName.put(parsedObject.getData().get(i).getName(),parsedObject.getData().get(i).getMale());
                countMale++;
            }else if (parsedObject.getData().get(i).getMale()==false){
                charName.put(parsedObject.getData().get(i).getName(),parsedObject.getData().get(i).getMale());
                countFemale++;
            }else {
                charName.put(parsedObject.getData().get(i).getName(),parsedObject.getData().get(i).getMale());
                countUnknown++;
            }
        }
//        System.out.println(String.format("%s is %s portrayed %s,in %s",listCharPojo.get(0).getName(),listCharPojo.get(0).getStatus()
//                ,listCharPojo.get(0).getPortrayed(), listCharPojo.get(0).getCategory()));
        System.out.println(String.format("%s and %s and %s ","Male "+countMale,"Female "+countFemale,"Unknown "+countUnknown));
        System.out.println(charName);
    }


    @Test
    public void sameBooks() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        // https://api.got.show/api/map/characters
        uriBuilder.setScheme("https").setHost("api.got.show").setPath("api/map/characters");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();
        // If we don't want to define all properties we use this method  // jackson.databind.exc.UnrecognizedPropertyException:
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        // If MGLT(All of them upper case cause of them java not give result) but we use this configure and reach solution
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
        ResponseBodyGOT parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(),ResponseBodyGOT.class);

        Set<String> setBooks=new HashSet<>();
        for(int i=0;i<parsedObject.getData().size();i++){
            for(int k=0;k<parsedObject.getData().get(i).getBooks().size();k++){
                setBooks.add(parsedObject.getData().get(i).getBooks().get(k));
            }
        }
 //       System.out.println(setBooks);


        Map<String,String> books=new HashMap<>();
        Map<String,Integer> countNames=new HashMap<>();
        Integer count1=1;
        Integer count2=1;
        Integer count3=1;
        Integer count4=1;
        Integer count5=1;
        Integer count6=1;
        Integer count7=1;

        for(int i=0;i<parsedObject.getData().size();i++){
            for(int k=0;k<parsedObject.getData().get(i).getBooks().size();k++){
                if(parsedObject.getData().get(i).getBooks().get(k).equalsIgnoreCase(THE_ROGUE_PRINCE)){
                    books.put(parsedObject.getData().get(i).getName(),THE_ROGUE_PRINCE);
                    if(countNames.containsKey(parsedObject.getData().get(i).getBooks().get(k))){
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),++count1);
                    }else{
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),count1);
                    }

                }
                else if(parsedObject.getData().get(i).getBooks().get(k).equalsIgnoreCase(A_STORM_OF_SWORDS)){
                    books.put(parsedObject.getData().get(i).getName(),A_STORM_OF_SWORDS);
                    if(countNames.containsKey(parsedObject.getData().get(i).getBooks().get(k))){
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),++count2);
                    }else{
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),count2);
                    }
                }
                else if(parsedObject.getData().get(i).getBooks().get(k).equalsIgnoreCase(A_CLASH_OF_KINGS)){
                    books.put(parsedObject.getData().get(i).getName(),A_CLASH_OF_KINGS);
                    if(countNames.containsKey(parsedObject.getData().get(i).getBooks().get(k))){
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),++count3);
                    }else{
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),count3);
                    }
                }
                else if(parsedObject.getData().get(i).getBooks().get(k).equalsIgnoreCase(A_FEAST_FOR_CROWS)){
                    books.put(parsedObject.getData().get(i).getName(),A_FEAST_FOR_CROWS);
                    if(countNames.containsKey(parsedObject.getData().get(i).getBooks().get(k))){
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),++count4);
                    }else{
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),count4);
                    }
                }
                else if(parsedObject.getData().get(i).getBooks().get(k).equalsIgnoreCase(A_GAME_OF_THRONES)){
                    books.put(parsedObject.getData().get(i).getName(),A_GAME_OF_THRONES);
                    if(countNames.containsKey(parsedObject.getData().get(i).getBooks().get(k))){
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),++count5);
                    }else{
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),count5);
                    }
                }
                else if(parsedObject.getData().get(i).getBooks().get(k).equalsIgnoreCase(THE_WINDS_OF_WINTER)){
                    books.put(parsedObject.getData().get(i).getName(),THE_WINDS_OF_WINTER);
                    if(countNames.containsKey(parsedObject.getData().get(i).getBooks().get(k))){
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),++count6);
                    }else{
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),count6);
                    }
                }
                else if(parsedObject.getData().get(i).getBooks().get(k).equalsIgnoreCase(DANCE_WITH_DRAGONS_THE_WINDS_OF_WINTER)){
                    books.put(parsedObject.getData().get(i).getName(),DANCE_WITH_DRAGONS_THE_WINDS_OF_WINTER);
                    if(countNames.containsKey(parsedObject.getData().get(i).getBooks().get(k))){
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),++count7);
                    }else{
                        countNames.put(parsedObject.getData().get(i).getBooks().get(k),count7);
                    }
                }
            }
        }

        System.out.println(countNames);
    }
}
