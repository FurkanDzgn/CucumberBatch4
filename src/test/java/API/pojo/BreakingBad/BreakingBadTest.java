package API.pojo.BreakingBad;

import API.PojoExample.StarWars.ResponseBodyStarWars;
import API.pojo.BreakingBad.Specific.BreakingBadSpecific;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.lv.Un;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreakingBadTest {

    private static final String ALIVE = "alive";
    private static final String DECEASED = "deceased";
    private static final String PRESUMED_DEAD = "presumed Dead";
    private static final String UNKOWN = "Unknown status?";
    @Test
    public void breakingBad() throws URISyntaxException, IOException {
        // Get https://breakingbadapi.com/api/characters
        // Deseriazliza response using POJO classes
        // Get alive and Decesed characters names (1 Map with only 3 keys : Alive, Deceased, Presumed dead)
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("breakingbadapi.com").setPath("api/characters");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        ObjectMapper objectMapper=new ObjectMapper();

        // If we don't want to define all properties we use this method  // jackson.databind.exc.UnrecognizedPropertyException:
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        // If MGLT(All of them upper case cause of them java not give result) but we use this configure and reach solution
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);

//        ResponseBodyBreakinB parsedObject=objectMapper.readValue(httpResponse.getEntity().getContent(),ResponseBodyBreakinB.class);
//        System.out.println(parsedObject.getCharacters().get(0).getMaps().get("name").getName());

        List<BreakingBad> breakingBadCharPojo= objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<List<BreakingBad>>() {});

        // Second way
//        List<BreakingBadSpecific> listCharPojo=objectMapper.readValue(httpResponse.getEntity().getContent(),
//                objectMapper.getTypeFactory().constructCollectionType(List.class,BreakingBadSpecific.class));

   //     System.out.println(breakingBadCharPojo.get(0).getName());

        Map<String,List<String>> charBycategory=new HashMap<>();
        List<String> alive = new ArrayList<>();
        List<String> deceased = new ArrayList<>();
        List<String> presumeDead = new ArrayList<>();
        List<String> unknownStatus = new ArrayList<>();

        for(int i=0;i<breakingBadCharPojo.size();i++){
            if(breakingBadCharPojo.get(i).getStatus().equalsIgnoreCase(ALIVE)){
                alive.add(breakingBadCharPojo.get(i).getName());
          //      charBycategory.put("alive",alive);
            }
            else if(breakingBadCharPojo.get(i).getStatus().equalsIgnoreCase(DECEASED)){
                deceased.add(breakingBadCharPojo.get(i).getName());
        //        charBycategory.put("deceased",deceased);
            }
            else if(breakingBadCharPojo.get(i).getStatus().equalsIgnoreCase(PRESUMED_DEAD)){
                presumeDead.add(breakingBadCharPojo.get(i).getName());
          //      charBycategory.put("presumed Dead",presumeDead);
            }
            else{
                unknownStatus.add(breakingBadCharPojo.get(i).getName());
            }
        }

        charBycategory.put(ALIVE,alive);
        charBycategory.put(DECEASED,deceased);
        charBycategory.put(PRESUMED_DEAD,presumeDead);
        charBycategory.put(UNKOWN,unknownStatus);

        System.out.println("List of alive characters"+charBycategory.get(ALIVE)+"\n");
        System.out.println("List of deceased characters"+charBycategory.get(DECEASED)+"\n");
        System.out.println("List of presume Dead characters"+charBycategory.get(PRESUMED_DEAD)+"\n");
        System.out.println("List of unknown_status characters"+charBycategory.get(UNKOWN)+"\n");

    }




}
