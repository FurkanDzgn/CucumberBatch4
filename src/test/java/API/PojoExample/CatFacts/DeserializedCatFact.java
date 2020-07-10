package API.PojoExample.CatFacts;

import API.pojo.UserPojo;
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
import java.util.List;

public class DeserializedCatFact {

    @Test
    public void catFact() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        //http://cat-fact.herokuapp.com/facts
        uriBuilder.setScheme("https").setHost("cat-fact.herokuapp.com").setPath("facts");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","Application/json");

        HttpResponse httpResponse=httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();
        ResponseBodyCatFact parsedCats=objectMapper.readValue(httpResponse.getEntity().getContent(),
                ResponseBodyCatFact.class);

        List<All> results=parsedCats.getAll();

        for(All re:results){
            try{
                System.out.println(re.getUser().getName().getFirst()+"-"+re.getUser().getName().getLast());
            }catch (NullPointerException e){

                e.printStackTrace();
            }
        }


    }
}
