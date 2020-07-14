package API.restassured;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredIntro {

    @Test
    public void rest1(){

        // https://swapi.dev/api/planets/1

//        given().header("contentType",ContentType.JSON).header("accept",ContentType.JSON)
//                .when().get("https://swapi.dev/api/planets/1").then().statusCode(200).and().contentType(ContentType.JSON);

        given().header("accept",ContentType.JSON)
                .when().get("https://swapi.dev/api/planets/1")
                .then().assertThat().statusCode(200).and().contentType(ContentType.JSON);

    }

    @Test
    public void rest2(){
        given().header("accept",ContentType.JSON).when().get("https://swapi.dev/api/planets/1")
                .then().statusCode(200).and().contentType(ContentType.JSON)
                .and().assertThat().body("name",equalTo("Tatooine"));
    }

    @Test
    public void rest3(){
        given().header("accept",ContentType.JSON).when().get("https://swapi.dev/api/planets")
                .then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .and().body("results[0].gravity", Matchers.is("1 standard"))
                .and().body("results[0].terrain",Matchers.isA(String.class))
                .and().body("results[0].residents.get(0)",Matchers.is("http://swapi.dev/api/people/1/"));

//        given().header("accept",ContentType.JSON).when().get("https://swapi.dev/api/planets")
//                .then().log().ifStatusCodeIsEqualTo(200).assertThat().statusCode(200).contentType(ContentType.JSON)
//                .and().body("results[0].gravity", Matchers.is("1 standard"))
//                .and().body("results[0].terrain",Matchers.isA(String.class));
    }

    @Test
    public void rest4(){
        given().header("accept",ContentType.JSON).when().get("https://swapi.dev/api/planets")
                .then().log().ifStatusCodeIsEqualTo(201).statusCode(200).and().contentType(ContentType.JSON)
                .and().body("results[1].residents[2]",Matchers.is("http://swapi.dev/api/people/81/"));
    }


}
