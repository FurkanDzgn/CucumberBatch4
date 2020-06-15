package StepDefinitions.com.herokuApp;

import Pages.HerokuAppPages.MainPage;
import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class HerokuAppSteps {

    WebDriver driver= Driver.getDriver();
    MainPage mainPage=new MainPage(driver);

    @Given("the user iframe page")
    public void the_user_iframe_page() {
       driver.get(ConfigReader.getProperty("herokuUrl"));

    }

    @Then("the user enters the text")
    public void the_user_enters_the_text(String docString) {
        BrowserUtils.switchFrameByIndex(driver,0);
        mainPage.textBox.clear();
        mainPage.textBox.sendKeys(docString);
    }

}
