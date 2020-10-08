package API.restassured.RestAssuredDeseralization2;

import com.github.wnameless.json.flattener.JsonFlattener;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class RestAssuredDeserialization4 {

    Response response;

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://breakingbadapi.com";
        RestAssured.basePath = "/api/characters";

        RestAssured.requestSpecification = new RequestSpecBuilder().setAccept(ContentType.JSON).build();
        RestAssured.responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
                .expectStatusCode(200).build();
        response = given().spec(requestSpecification)
                .when().get().
                        then().spec(responseSpecification)
                .extract().response();
    }

    @Test
    public void test1(){
        System.out.println(response.asString());
        String res = response.asString();
        Map<String,Object> jsonGet = JsonFlattener.flattenAsMap(res);
        System.out.println(jsonGet.get("[1].char_id"));
    }
}
