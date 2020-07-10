package API.restassured;

import API.pojo.Petstore.ResponseBody;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredDeserialization3 {

    /*Write a cucumber scenario
   https://petstore.swagger.io/v2/pet/10
   deserialize with POJO
   do verifications
   */
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
}
