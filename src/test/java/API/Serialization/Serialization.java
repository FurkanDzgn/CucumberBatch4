package API.Serialization;

import Utils.PayloadUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Serialization {

    @Test
    public void serialz1() throws IOException {

        Pet pet=new Pet("Hatiko","waiting",3);
        pet.setId(1);
        pet.setPhotoUrl("https://s3.petpics.amazon.com");

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(new File("target/pet.json"), pet);
    }

    @Test
    public void serialz2() throws IOException {
        Car car=new Car("Honda",2008,150000);
//        car.setAge(12);
//        car.setValue("civic");

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(new File("target/car.json"), car);
    }

    @Test
    public void serialz3() throws IOException {
        ClassMembers classMembers=new ClassMembers();
        classMembers.setName("Frank");
        classMembers.setCapacity(55);
        classMembers.setLocation("Des Plains");
        classMembers.setTeacher("Muammer");
        classMembers.setTotals(47);

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(new File("target//classMembers.json"),classMembers);

    }

    @Test
    public void createPet() throws URISyntaxException, IOException {

        HttpClient httpClient= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("/v2/pet");

        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("Accept","application/json");

      //  String petPayload=new String(Files.readAllBytes(Paths.get("target/pet.json"))); // inside HEAP outside String Pool

        String petPayload=PayloadUtils.generateStringFromResource("target/pet.json");

        HttpEntity httpEntity=new StringEntity(petPayload);
        httpPost.setEntity(httpEntity);

        HttpResponse httpResponse=httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

    }

}
