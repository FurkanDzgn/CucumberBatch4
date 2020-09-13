package StepDefinitions;

import Pages.MayAppPages.MyAppHomePage;
import Utils.ConfigReader;
import Utils.Driver;
import Utils.JDBCUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.beans.binding.ObjectExpression;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAppSteps {

    WebDriver driver = Driver.getDriver();
    MyAppHomePage myAppHomePage = new MyAppHomePage();
    List<Map<String, Object>> UIData = new ArrayList<>();

    @Given("User goes to myApp homepage")
    public void user_goes_to_myApp_homepage() {
        driver.navigate().to(ConfigReader.getProperty("myApp"));
    }

    @When("User gets the data from UI")
    public void user_gets_the_data_from_UI() {
        List<String> columns= new ArrayList<>();

        for(int i=0; i<myAppHomePage.columns.size();i++){
            columns.add(myAppHomePage.columns.get(i).getText());
        }

        Map<String,Object> row1 = new HashMap<>();
        for(int i=0; i<myAppHomePage.row1.size(); i++){
            row1.put(columns.get(i), myAppHomePage.row1.get(i).getText());
        }

        Map<String,Object> row2 = new HashMap<>();
        for(int i=0; i<myAppHomePage.row2.size(); i++){
            row1.put(columns.get(i), myAppHomePage.row2.get(i).getText());
        }

        Map<String,Object> row3 = new HashMap<>();
        for(int i=0; i<myAppHomePage.row3.size(); i++){
            row1.put(columns.get(i), myAppHomePage.row3.get(i).getText());
        }

        Map<String,Object> row4 = new HashMap<>();
        for(int i=0; i<myAppHomePage.row4.size(); i++){
            row1.put(columns.get(i), myAppHomePage.row4.get(i).getText());
        }
        UIData.add(row1);
        UIData.add(row2);
        UIData.add(row3);
        UIData.add(row4);
    }

    @Then("User validates UI data with DB")
    public void user_validates_UI_data_with_DB() throws SQLException {

        // first_name, last_name, employee_id
        JDBCUtils.establishConnection();
        List<Map<String,Object>> DBData = JDBCUtils.runQuery("select first_name, last_name, employee_id, job_title\n" +
                "from employees e join jobs j on\n" +
                "e.job_id = j.job_id\n" +
                "Where employee_id in(100, 105, 119, 125)");

        // UIData validated with DBData

        for(int i=0; i<UIData.size();i++){
            Assert.assertEquals(UIData.get(i).get("Name").toString(),DBData.get(i).get("FIRST_NAME").toString());
            Assert.assertEquals(UIData.get(i).get("Last Name").toString(),DBData.get(i).get("LAST_NAME").toString());
            Assert.assertEquals(UIData.get(i).get("Employee ID").toString(),DBData.get(i).get("EMPLOYEE_ID").toString());
            Assert.assertEquals(UIData.get(i).get("JOB_TITLE").toString(),DBData.get(i).get("JOB_TITLE").toString());
        }



    }

}
