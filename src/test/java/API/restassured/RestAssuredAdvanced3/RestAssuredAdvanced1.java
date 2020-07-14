package API.restassured.RestAssuredAdvanced3;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class RestAssuredAdvanced1 {

    Response response;

    @Before
    public void setUp(){
        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "v2/competitions/2000/scorers";

        RestAssured.requestSpecification = new RequestSpecBuilder().setAccept(ContentType.JSON)
            .addHeader("X-Auth-Token","42722579a6824fceb9bc68800e4e42c5").build();
        RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        response = given().spec(requestSpecification)
                .when().get().then().spec(responseSpecification).extract().response();

    }

    @Test
    public void adv1(){

        int numberOfGoalsByHarryKane = response.path("scorers.find { it.player.name == 'Harry Kane' }.numberOfGoals ");
        Assert.assertEquals(6,numberOfGoalsByHarryKane);

    }

    @Test
    public void adv2(){

        String countryOfBirthOfDennis = response.path("scorers.find {it.player.name == 'Denis Cheryshev'}.player.countryOfBirth");
        String teamName = response.path("scorers.find {it.player.name == 'Denis Cheryshev'}.team.name");
        Assert.assertEquals("Russia",countryOfBirthOfDennis);
        Assert.assertEquals("Russia",teamName);

//        List<String> namesOfRussia = response.path("scorers.findAll {it.player.id > 100 }.team.name");
//        System.out.println(namesOfRussia);
    }

    @Test
    public void adv3(){
        String playerWithMaxGoals = response.path("scorers.max {it.numberOfGoals }.player.name");
        System.out.println(playerWithMaxGoals);

        String playerWithMinGoals = response.path("scorers.min {it.numberOfGoals }.player.name");
        System.out.println(playerWithMinGoals);

    }

    @Test
    public void adv4(){
        int minGoals = response.path("scorers.min {it.numberOfGoals }.numberOfGoals");

        List<String> minScorers =  response.path("scorers.findAll {it.numberOfGoals =="+minGoals+" }.player.name");

   //     List<String> minScorers2 =  response.path("scorers.findAll {it.numberOfGoals == %s ,minGoals}.player.name");
        List<String> minScorers1=response.path(String.format("scorers.findAll{ it.numberOfGoals == %s}.player.name",minGoals));

        System.out.println(minScorers);
        System.out.println(minScorers1);

    }

    @Test
    public void adv5(){
        response.then().body("scorers.find {it.player.name == 'Harry Kane'}.numberOfGoals", Matchers.equalTo(6));
    }
    @Test
    public void adv6(){
//        response.then().assertThat().body("scorers.findAll {it.team.name == 'Russia'}.size()",Matchers.greaterThan(0));
//        response.then().assertThat().body("scorers.findAll {it.team.name == 'Russia'}.team.name.size()",Matchers.equalTo(2));
//        response.then().assertThat().body("scorers.findAll {it.team.name == 'Russia'}",Matchers.hasSize(2));
        response.then().assertThat().body("scorers[0].team.name",Matchers.is("England"));
        response.then().assertThat().body("scorers[0].team.name",Matchers.equalTo("England")).log().all();

    }

    @Test
    public void adv7(){
        response.then().body("scorers.collect {it.team.name}",Matchers.hasItem("Turkey"));
        response.then().body("scorers.collect {it.team.name}",Matchers.hasItems("England","Portugal"));
    }

}
