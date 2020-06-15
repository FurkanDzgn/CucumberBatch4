package StepDefinitions.com.duckduckgo;

import Pages.DuckDuckGoPages.SearchPackage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBoxSteps {

    WebDriver driver= Driver.getDriver();
    SearchPackage page=new SearchPackage(driver);

    @Given("the user goes to the duckduckgo")
    public void the_user_goes_to_the_duckduckgo() {
 //       page=new SearchPackage(driver);
  //      driver.get("https://duckduckgo.com/");
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("the user send the selenium keyword")
    public void the_user_send_the_selenium_keyword() {
//        page.searchBox.sendKeys("selenium");
        page.searchBox.sendKeys(ConfigReader.getProperty("searchValue"));
    }

    @Then("the user click search button")
    public void the_user_click_search_button() {
        page.searchButton.click();
    }

    @Then("the user validate title contains the selenium keyword")
    public void the_user_validate_title_contains_the_selenium_keyword() {

        String actualTitle=driver.getTitle();
  //      Assert.assertTrue(actualTitle.contains("selenium")); // Assert is coming from JUnit
        Assert.assertTrue(actualTitle.contains(ConfigReader.getProperty("searchValue")));
    }

    @Then("the user validate url contains the selenium keyword")
    public void the_user_validate_url_contains_the_selenium_keyword() {

        String actualUrl=driver.getCurrentUrl();

 //       Assert.assertTrue(actualUrl.contains("selenium"));
        Assert.assertTrue(actualUrl.contains(ConfigReader.getProperty("searchValue")));

    }

    @Then("the user validate all results contain the selenium keyword")
    public void the_user_validate_all_results_contain_the_selenium_keyword() {

   //     Assert.assertTrue(page.searchResult.size()==10);
        for (WebElement element:page.searchResult){
          //  Assert.assertTrue(element.getText().contains("Selenium"));
            Assert.assertTrue(element.getText().contains(ConfigReader.getProperty("result")));
        }
    }

    @When("the user search with {string}")
    public void the_user_search_with(String string) {
       page.searchBox.sendKeys(string);
    }

    @When("the user validate title contains {string}")
    public void the_user_validate_title_contains(String string) {
       Assert.assertTrue(driver.getTitle().contains(string));
    }

    @When("the user validate all results contains {string}")
    public void the_user_validate_all_results_contains(String string) {

        for(WebElement result:page.searchResult){
            System.out.println(result.getText());
            Assert.assertTrue(result.getText().contains(string));
        }
    }

    @When("the user validate number of result is {int}")
    public void the_user_validate_number_of_result_is(Integer int1) { // --> int int1

        int res=int1;
        Assert.assertEquals(res,page.searchResult.size());
    }


}
