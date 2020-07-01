package Pages.DuckDuckGoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class SearchPackage {

    public SearchPackage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(name="q")
    public WebElement searchBox;

    @FindBy(id="search_button_homepage")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@class='result__a']") // //div[@class='results--main']//a[@class='result__a']
    public List<WebElement> searchResult;

}
