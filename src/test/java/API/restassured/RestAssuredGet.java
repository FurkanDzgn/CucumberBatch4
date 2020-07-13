package API.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredGet {

    @Before
    public void setUp(){
        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath="v2/pet";
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
