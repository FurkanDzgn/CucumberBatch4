package API.restassured.RestAssuredMethods1;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredGet {

    @Before
    public void setUp(){
        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath="v2/pet";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setAccept(ContentType.JSON).build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }

    @Test
    public void getPet0(){
        given().spec(requestSpecification)
                .when().get("101")
                .then().spec(responseSpecification);
    }

    @Test
    public void getPet(){
        given().accept(ContentType.JSON)
                .when().get("45345")
                .then().contentType(ContentType.JSON).statusCode(200);
    }

    @Test
    public void getPet2(){
        given().accept(ContentType.JSON)
                .when().get("{id}",45345)
                .then().contentType(ContentType.JSON).statusCode(200);
    }

    @Test
    public void getPet3(){
        given().accept(ContentType.JSON)
                .when().request("GET","45345")
                .then().statusCode(200).contentType(ContentType.JSON);
    }

    @Test
    public void getPet4(){
        given().accept(ContentType.JSON)
                .when().request("GET","{id}",45345)
                .then().statusCode(200).contentType(ContentType.JSON)
                .log().body(false);
    }
}
