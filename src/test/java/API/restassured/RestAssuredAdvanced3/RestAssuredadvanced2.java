package API.restassured.RestAssuredAdvanced3;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;

import java.util.Map;

import static io.restassured.RestAssured.*; // * wildcard

public class RestAssuredadvanced2 {


    @Before
    public void setUp(){
        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "v2/competitions/2000/scorers";

        RestAssured.requestSpecification = new RequestSpecBuilder().setAccept(ContentType.JSON)
                .addHeader("X-Auth-Token","42722579a6824fceb9bc68800e4e42c5").build();
        RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();


        Response response = given().spec(requestSpecification).when().get().then().spec(responseSpecification).extract().response();

        Map<String, ?> map = response.as(Map.class);
       // Map<?, ?> map1 = response.as(Map.class);
      //  String status = (String) map.get("status");
        System.out.println(map.get("count"));

    }
}
