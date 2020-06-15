package Pages.WebOrderPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="ctl00_MainContent_username")
    public WebElement userName;

    @FindBy(id="ctl00_MainContent_password")
    public WebElement password;

    @FindBy(id="ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement errorText;

    public void login(String username,String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public String getErrorText(){

        return errorText.getText();
    }
    /*
    WebElement loginButton=driver.findElement(By.id("loginButton"));
    driver.navigate().refresh();
    loginButton.click();

    loginButton=driver.findElement(By.id("loginButton")); // staleElementException
    loginButton.click();
     */

    /*
     PageFactory.initElements(driver,LoginPage.class);
     -->> It will solve the issue  staleElementException if the  element is refreshed on the page
     -->> this is inside the stepDefinition class
     */


}
