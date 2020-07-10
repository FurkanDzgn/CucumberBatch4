package API.pojo.BreakingBad.Specific;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class BreakingBadSpeTest {
    // GET https://breakingbadapi.com/api/characters/12
    // Deserialize response using POJO class
    // Print out "NameOfChar" is "STATUS", portrayed: "value", in "category"
    @Test
    public void tes1t() throws URISyntaxException, IOException {

        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("breakingbadapi.com").setPath("api/characters/12");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);

        ObjectMapper objectMapper=new ObjectMapper();

        // If we don't want to define all properties we use this method  // jackson.databind.exc.UnrecognizedPropertyException:
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        // If MGLT(All of them upper case cause of them java not give result) but we use this configure and reach solution
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);

        List<BreakingBadSpecific> listCharPojo=objectMapper.readValue(httpResponse.getEntity().getContent(),
               objectMapper.getTypeFactory().constructCollectionType(List.class,BreakingBadSpecific.class));

        System.out.println(String.format("%s is %s portrayed %s,in %s",listCharPojo.get(0).getName(),listCharPojo.get(0).getStatus()
        ,listCharPojo.get(0).getPortrayed(), listCharPojo.get(0).getCategory()));

//        System.out.println(listCharPojo.get(0).getName() +" is "+listCharPojo.get(0).getStatus()+ " portrayed: "+
//                listCharPojo.get(0).getPortrayed() + ",in"+listCharPojo.get(0).getCategory());

//        System.out.println(listCharPojo.get(0).getName());
//        System.out.println(listCharPojo.get(0).getCategory());
//        System.out.println(listCharPojo.get(0).getPortrayed());
//        System.out.println(listCharPojo.get(0).getStatus());
    }
}
