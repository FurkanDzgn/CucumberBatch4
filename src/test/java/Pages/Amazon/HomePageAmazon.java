package Pages.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAmazon {

    public HomePageAmazon(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id ="nav-search-submit-text")
    public WebElement searchButton;


}
