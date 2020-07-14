package API.restassured.RestAssuredMethods1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredPut extends RestAssuredPost {

    @Before
    public void setUp(){
        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath="v2/pet";
    }

    @Test
    public void uptadePet(){

        File uptadePetPayload = new File("target/pet.json");

        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(uptadePetPayload)
                .when().put()
                .then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .and().body(NAME, Matchers.equalTo("Hatiko"))
                .and().body(RestAssuredPost.STATUS,Matchers.is("waiting")).log().all();

        // extends the class or write together (RestAssuredPost.STATUS)
    } @Test
    public void uptadePet2(){

        // PUT https://petstore.swagger.io/v2/pet
        // Using map provide request body, with uptated status of a pet, that you just created do verifications

        Map<String,Object> uptadePetPayload = new HashMap<>();
        uptadePetPayload.put(RestAssuredPost.NAME,"Pretzel");
        uptadePetPayload.put("id",45345);
        uptadePetPayload.put(RestAssuredPost.STATUS,"available");
//        String[] urls = {"https://s3.petpics.amazon.com"};
//        uptadePetPayload.put("photoUrl",urls);
//        uptadePetPayload.put("age",3);

        given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(uptadePetPayload)
                .when().put()
                .then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .body(RestAssuredPost.NAME,Matchers.is(uptadePetPayload.get(RestAssuredPost.NAME)))
                .log().all();
    }




}
