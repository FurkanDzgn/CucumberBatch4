package StepDefinitions.com.weborder;

import Pages.WebOrderPages.HomePage;
import Pages.WebOrderPages.LoginPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {

    WebDriver driver= Driver.getDriver();
    LoginPage loginPage=new LoginPage(driver);
    HomePage homePage=new HomePage(driver);

//    @Before
//    public void message(){
//        System.out.println("Login Page Step Class");
//    }
//
//    @BeforeStep
//    public void beforeStep(){
//        System.out.println("Before Step Annotation");
//    }
//
//    @AfterStep
//    public void afterStep(){
//        System.out.println("After Step Annotation");
//    }

    @Given("the demoUser enters username")
    public void the_demoUser_enters_username() {
        driver.navigate().to(ConfigReader.getProperty("webOrderUrl"));
        loginPage.userName.sendKeys(ConfigReader.getProperty("userNameWebOrder"));
    }

    @When("the demoUser enters password")
    public void the_demoUser_enters_password() {
       loginPage.password.sendKeys("test");
    }

    @Then("the demoUser clicks the login button")
    public void the_demoUser_clicks_the_login_button() {
       loginPage.loginButton.click();
    }

    @Then("the demoUser validate the home page")
    public void the_demoUser_validate_the_home_page() {
        String actualTitle=driver.getTitle();
        String expectedTitle="Web Orders";
        Assert.assertEquals(expectedTitle,actualTitle);
        Assert.assertTrue(homePage.logOutButton.isDisplayed());
        Assert.assertTrue(homePage.welcomeText.getText().contains("Welcome, Tester!"));
   //   System.out.println(homePage.welcomeText.getText());

    }

    @Given("the demoUser enters username {string}")
    public void the_demoUser_enters_username(String username) {
        driver.navigate().to(ConfigReader.getProperty("webOrderUrl"));
        loginPage.userName.sendKeys(username);
    }

    @When("the demoUser enters password {string}")
    public void the_demoUser_enters_password(String password) {
        loginPage.password.sendKeys(password);
    }

    @Then("the demoUser clicks the login Button")
    public void the_demoUser_clicks_the_login_Button() {
        loginPage.loginButton.click();
    }

    @Then("the demoUser validate the text {string}")
    public void the_demoUser_validate_the_text(String expected) {
        Assert.assertEquals( "Error Meage Validation",expected,loginPage.errorText.getText());
    }
}
