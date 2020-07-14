package API.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssured2 {

    @Test
    public void getRequest1(){
//       given().header("accept", ContentType.JSON).when().get("https://breakingbadapi.com/api/characters/50")
//               .then().log().ifValidationFails().assertThat().statusCode(200).and().contentType(ContentType.JSON)
//               .body("[0].name", Matchers.equalToIgnoringCase("Juan Bolsa"))
//               .and().body("[0].occupation",Matchers.hasSize(1));


       given().header("accept",ContentType.JSON)
               .when().get("https://breakingbadapi.com/api/characters/50")
               .then().assertThat().statusCode(200).contentType(ContentType.JSON)
               .log().all()
               .body("[0].occupation[0]",Matchers.is("Mexican drug cartel boss"));

    }

    @Test
    public void getRequest2(){
//        given().header("accept",ContentType.JSON).when().get("https://breakingbadapi.com/api/characters/50")
//                .then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON)
//                .body("[0].status",Matchers.is("Deceased"))
//                .body("[0].nickname",Matchers.equalTo("Don Juan"))
//                .body("[0].appearance.size()",Matchers.greaterThan(1))
//                .body("[0].appearance[0]",Matchers.equalTo(3));

        //       .body("[0].portrayed",Matchers.is("Javier Grajeda"));
        // body("[0].appearance",Matchers.hasSize(2)).and()

        given().header("accept",ContentType.JSON).when().get("https://breakingbadapi.com/api/characters/50")
                .then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .and().rootPath("[0]")
                .body("status",Matchers.is("Deceased"))
                .body("nickname",Matchers.equalTo("Don Juan"))
                .body("appearance.size()",Matchers.greaterThan(1))
                .body("appearance[0]",Matchers.equalTo(3));
    }

    @Test
    public void getRequest3(){

//        given().header("accept",ContentType.JSON)
//                .when().get("https://api.got.show/api/map/characters/byId/5cc0743504e71a0010b852d9")
//                .then().log().ifStatusCodeIsEqualTo(500).assertThat().statusCode(200)
//                .contentType(ContentType.JSON)
//                .body("data.books",Matchers.hasItem("A Storm of Swords"))
//                .body("data.dateOfBirth",Matchers.equalTo(283))
//                .body("data.house",Matchers.is("House Stark"))
//                .body("data.male",Matchers.isA(Boolean.class));

        RestAssured.baseURI="https://api.got.show";
        RestAssured.basePath="api/map/characters/byId/5cc0743504e71a0010b852d9";
        given().header("accept",ContentType.JSON)
                .when().get()
                .then().log().ifStatusCodeIsEqualTo(500).assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .rootPath("data")
                .body("books",Matchers.hasItem("A Storm of Swords"))
                .body("dateOfBirth",Matchers.equalTo(283))
                .body("house",Matchers.is("House Stark"))
                .body("male",Matchers.isA(Boolean.class));

    }
}
