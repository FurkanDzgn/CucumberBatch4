package StepDefinitions.API;

import Utils.PayloadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

public class ApiStepDef {

    HttpClient httpClient;
    URIBuilder uriBuilder;
    HttpResponse httpResponse;
    int num;
    String name;
    String status;
    @When("user creates a pet with {string}, {string}, {string}")
    public void user_creates_a_pet_with(String number, String nameFSE, String statusFSE) throws URISyntaxException, IOException {
        num = Integer.parseInt(number);
        name = nameFSE;
        status = statusFSE;
        httpClient= HttpClientBuilder.create().build();
        uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");
        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("Accept","application/json");

        HttpEntity httpEntity=new StringEntity(PayloadUtils.getPetPayload(num,name,status));
        httpPost.setEntity(httpEntity);
        httpResponse=httpClient.execute(httpPost);

    }

    @Then("the status code is {int}")
    public void the_status_code_is(Integer int1) {
        int expected=int1;
        Assert.assertEquals(expected,httpResponse.getStatusLine().getStatusCode());
    }

    @Then("pet with {string}, {string}, {string} is created")
    public void pet_with_is_created(String number, String nameFSE, String statusFSE) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String,Object> parsed=objectMapper.readValue(httpResponse.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        num = Integer.parseInt(number);
        name = nameFSE;
        status = statusFSE;
        Assert.assertEquals(num,parsed.get("id"));
        Assert.assertEquals(name,parsed.get("name"));
        Assert.assertEquals(status,parsed.get("status"));

    }


}
