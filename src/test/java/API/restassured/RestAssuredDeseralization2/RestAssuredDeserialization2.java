package API.restassured.RestAssuredDeseralization2;


import API.pojo.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredDeserialization2 {

    @Test
    public void getUser(){

        UserPojo parsedUser=given().header("accept", ContentType.JSON)
                .when().request("GET","https://reqres.in/api/users/2")
                .then().statusCode(200)
                .and().contentType(ContentType.JSON)
                .extract()
                .as(UserPojo.class);

        Assert.assertEquals("janet.weaver@reqres.in",parsedUser.getData().getEmail());
    }

    @Test
    public void getUser2(){

        //Prerequisite
        RequestSpecification requestSpecification = given().header("accept",ContentType.JSON);

        //Action -> getting response
        Response response = requestSpecification.when().get("https://reqres.in/api/users/2");

        //validation1
        ValidatableResponse validatableResponse = response.then().statusCode(200).and().contentType(ContentType.JSON);

        //deserialization
        UserPojo deserializedUser = validatableResponse.log().all().extract().as(UserPojo.class);

        //Validation2
        Assert.assertEquals("Janet",deserializedUser.getData().getFirst_name());
    }
}
