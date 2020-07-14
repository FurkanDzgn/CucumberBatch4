package API.restassured.RestAssuredDeseralization2;

import API.pojo.BreakingBad.BreakingBad;
import API.pojo.Petstore.ResponseBody;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class RestAssuredDeserialization3 {

    /*Write a cucumber scenario
   https://petstore.swagger.io/v2/pet/10
   deserialize with POJO
   do verifications
   */

//    Response response;
//    @Before
//    public void setUp(){
//        RestAssured.baseURI = "https://petstore.swagger.io";
//        RestAssured.basePath = "v2/pet/10";
//
//        RestAssured.requestSpecification = new RequestSpecBuilder().setAccept(ContentType.JSON).build();
//        RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//        response = given().spec(requestSpecification).when().get().then().spec(responseSpecification).extract().response();
//    }
//
//    @Test
//    public void petStore0(){
//
//        ResponseBody parsedPed = response.getBody().as(ResponseBody.class);
//   //     ResponseBody parsedPed = response.getBody().as(new TypeRef<ResponseBody>() {});
//
//        System.out.println(parsedPed.getId());
//    }

    @Test
    public void petStore(){
        ResponseBody parsedPet=given().header("accept", ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/10")
                .then().statusCode(200).and().contentType(ContentType.JSON)
                .log().ifStatusCodeIsEqualTo(500)
                .extract()
                .as(ResponseBody.class);

        Assert.assertEquals("AriLrzKmNeQ_2_Kg'));select pg_sleep(2); -- ",parsedPet.getTags().get(0).getName());
        Assert.assertEquals(179,parsedPet.getTags().get(0).getId());
    }

    @Test
    public void breBad(){

        RequestSpecification requestSpecification = given().header("accept",ContentType.JSON);
        Response response = requestSpecification.when().get("https://breakingbadapi.com/api/characters");
        ValidatableResponse validatableResponse=response.then().statusCode(200).and().contentType(ContentType.JSON);

        List<BreakingBad> parsedPojo = validatableResponse.extract().as(new TypeRef<List<BreakingBad>>() {});

        Assert.assertEquals("Walter White",parsedPojo.get(0).getName());

//        List<BreakingBad> parsedPojo =given().header("accept",ContentType.JSON)
//        .when().get("https://breakingbadapi.com/api/characters")
//        .then().statusCode(200).and().contentType(ContentType.JSON)
//                .extract().as(new TypeRef<List<BreakingBad>>() {
//                });
//
//        Assert.assertEquals("Walter White",parsedPojo.get(0).getName());



    }


}
