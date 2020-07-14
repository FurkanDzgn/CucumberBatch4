package API.restassured.RestAssuredDeseralization2;

import API.pojo.BreakingBad.BreakingBad;
import io.restassured.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class RestAssuredDeseralization {

    Response response;
    @Before
    public void setUp(){
        RestAssured.baseURI="https://breakingbadapi.com";
        RestAssured.basePath="/api/characters";

//        RestAssured.requestSpecification = new RequestSpecBuilder().setAccept(ContentType.JSON).build();
//        RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//        response = given().spec(requestSpecification)
//                .when().get("50")
//                .then().spec(responseSpecification)
//                .extract().response();
    }

    @Test
    public void desr0(){

        List<BreakingBad> badList = response.getBody().as(new TypeRef<List<BreakingBad>>() {});
        Assert.assertEquals("Juan Bolsa",badList.get(0).getName());

    }

    @Test
    public void deser(){

        List<BreakingBad> chracterResp = given().header("accept", ContentType.JSON).when().get("50")
                .then().statusCode(200).and().contentType(ContentType.JSON)
                .extract()
                .as(new TypeRef<List<BreakingBad>>() {});

        Assert.assertEquals("Juan Bolsa",chracterResp.get(0).getName());

    }

    @Test
    public void deser2(){

        /*
        GET https://breakingbadapi.com/api/characters/35
        deserialize with POJO class
        verify status code, header(content type) birthday. size of appearance array, nickname
         */

       List<BreakingBad> charcterResp=given().header("accept",ContentType.JSON).when().get("35")
               .then().statusCode(200).and().contentType(ContentType.JSON)
               .extract()
               .as(new TypeRef<List<BreakingBad>>() {
               });

       Assert.assertEquals(2,charcterResp.get(0).getAppearance().size());
       Assert.assertEquals("Dr. Delcavoli",charcterResp.get(0).getNickname());
       Assert.assertEquals("Unknown",charcterResp.get(0).getBirthday());

    }

}
