package API.restassured.RestAssuredAdvanced3;

import API.pojo.FootballApi.Competitions;
import API.pojo.FootballApi.ResponseBodyFootball;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class RestAssuredAdvanced {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @Before
    public void setUp(){
        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "v2/competitions/";

         requestSpecification = new RequestSpecBuilder().setAccept(ContentType.JSON).build();
         responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
         response =given().spec(requestSpecification).when().get().then().spec(responseSpecification)
                .extract().response();
    }

    @Test
    public void adv1(){

        ResponseBodyFootball parsedObject = response.getBody().as(ResponseBodyFootball.class);
        System.out.println(parsedObject.getCompetitions().get(0).getName());

        List<Competitions> competitionsList = parsedObject.getCompetitions();

        for(Competitions map: competitionsList){
            int id = (int) map.getId();
            if(id >= 2100){
                System.out.println(map.getName());

            }
        }

    }

    @Test
    public void adv2(){

        JsonPath jsonPath = response.jsonPath();
   //     System.out.println(jsonPath.getString("competitions[0].name"));
        List<Map<String,Object>> competitions = jsonPath.getList("competitions");

        for(int i=0; i<competitions.size();i++){
            int id = (int) competitions.get(i).get("id");
            if(id >= 2100){
                System.out.println(competitions.get(i).get("name"));

            }
        }
    }

    @Test
    public void adv3(){
        // Groovy function
        List<String> competitionList = response.path("competitions.findAll { it.id >2100 }.name");
        System.out.println(competitionList);
//        if("competitions[0].id > 2100"){
//            "competitions[0].name"
//        }

    }

    @Test
    public void adv4(){

        // using Groovy findAll function, print out the competition names in Mexico

   //     List<String> mexico = response.path("competitions.findAll {it.area.name == 'Mexico' }.area.name");
        List<String> mexico = response.path("competitions.findAll {it.area.name == 'Mexico' }.name");
        System.out.println(mexico);

    }

}
