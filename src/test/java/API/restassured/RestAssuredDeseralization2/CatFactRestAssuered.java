package API.restassured.RestAssuredDeseralization2;

import API.pojo.CatFactClass.CatfactResponseBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CatFactRestAssuered {

    @Before
    public void setUp(){
        RestAssured.baseURI= "http://cat-fact.herokuapp.com";
        RestAssured.basePath = "facts";
    }

    @Test
    public void catFact(){
        // Get http://cat-fact.herokuapp.com/facts
        // get 25th cat fact out the id, fact, author.name, author.last_name
        //using RestAssured

       Response response =  given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get()
                .then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .extract().response();

        CatfactResponseBody catfact =response.as(CatfactResponseBody.class);

        System.out.println(catfact.getAll().get(24).get_id());
        System.out.println(catfact.getAll().get(0).getUser().getName().getFirst());
        System.out.println(catfact.getAll().get(0).getUser().getName().getLast());
    }
}
