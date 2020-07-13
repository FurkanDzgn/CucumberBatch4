package API.restassured;

import API.PojoExample.CatFacts.Name;
import API.pojo.PetPojo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredPost {

    public static final String NAME = "name";
    public static final String STATUS = "status";
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";

        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON).build();

        responseSpecification = new ResponseSpecBuilder().log(LogDetail.ALL)
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
    }
    @Test
    public void createPet(){
        File petPayloadFile = new File("target/pet.json");
        given().spec(requestSpecification)
                .body(petPayloadFile)
                .when().post()
                .then().spec(responseSpecification)
                .body(NAME, Matchers.equalTo("Hatiko"))
                .and().body(STATUS,Matchers.is("waiting"));
//                .and().body("id",Matchers.equalTo(1));


    }

    @Test
    public void createPet2(){

        PetPojo petPojo = new PetPojo("hatiko","gone",101);

        given().spec(requestSpecification)
                .body(petPojo)
                .when().post()
                .then().spec(responseSpecification)
                .body(NAME, Matchers.equalTo(petPojo.getName()))
                .and().body(STATUS,Matchers.is(petPojo.getStatus())).log().body();


    }

    @Test
    public void createPet3(){

        Map<String,Object> petPayload = new HashMap<>();
        petPayload.put(NAME,"Hatiko");
        petPayload.put("age",3);
        petPayload.put(STATUS,"waiting");
        petPayload.put("id",1);
        String[] urls = {"https://s3.petpics.amazon.com"};
        petPayload.put("photoUrl",urls);

        given().spec(requestSpecification)
                .body(petPayload)
                .when().post()
                .then().log().ifValidationFails().assertThat().spec(responseSpecification)
                .body(NAME , Matchers.is(petPayload.get(NAME)))
                .log().body();

    }
}
