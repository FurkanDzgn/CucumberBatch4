package StepDefinitions.API;

import API.pojo.Petstore.ResponseBody;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class PetStoreSteps {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Given("contentType head is set to {string}")
    public void contenttypeHeadIsSetTo(String requestHeader) {

        requestSpecification=given().header("accept", requestHeader);
    }
    @When("user executes GET request")
    public void userExecutesGETRequest(String requestType) {
       response=requestSpecification.request(requestType,"https://petstore.swagger.io/v2/pet/10");
    }
//    @Then("the status code is OK")
//    public void theStatusCodeIsOK() {
//       validatableResponse = response.
//
//    }
    @Then("contentType header is {string}")
    public void contenttypeHeaderIs(String responseHeader) {

        validatableResponse = response.then().statusCode(200).and().contentType(responseHeader);
    }
    @Then("users verfied {int}, {string}, {int} size")
    public void usersVerfiedDoggieSize(Integer id,String name,  Integer tagSize) {

        ResponseBody petPojo=validatableResponse.extract().as(ResponseBody.class);
        Assert.assertEquals((int)id,petPojo.getId());
        Assert.assertEquals(name,petPojo.getName());
        Assert.assertEquals(java.util.Optional.ofNullable(tagSize),petPojo.getTags().size());
    }

}
