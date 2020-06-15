package StepDefinitions.com.etsy;

import Pages.EtsyPages.EtsyHomePage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class EtsySteps {

    WebDriver driver= Driver.getDriver();
    EtsyHomePage etsyHomePage=new EtsyHomePage(driver);

    @Given("the user goes to the Etsy")
    public void the_user_goes_to_the_Etsy() {

        driver.get(ConfigReader.getProperty("etsyUrl"));
    }

    @When("the user search in etsy with {string}")
    public void the_user_search_in_etsy_with(String searchValue) {

        etsyHomePage.searchBox.sendKeys(searchValue);
        etsyHomePage.searchBox.sendKeys(Keys.ENTER);
      //  etsyHomePage.searchButton.click();  /  --> second option

    }

    @Then("the user validate the title {string} and url {string}")
    public void the_user_validate_the_title_and_url(String expectedTitle, String expectedUrl) {
        Assert.assertEquals(expectedTitle,driver.getTitle());
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
    }
}
