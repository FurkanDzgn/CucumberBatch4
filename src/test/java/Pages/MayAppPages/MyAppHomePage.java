package Pages.MayAppPages;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAppHomePage {

    public MyAppHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table//tbody//tr[1]//th")
    public List<WebElement> columns;
    @FindBy(xpath = "//table//tbody//tr[1]//td")
    public List<WebElement> row1;
    @FindBy(xpath = "//table//tbody//tr[2]//td")
    public List<WebElement> row2;
    @FindBy(xpath = "//table//tbody//tr[3]//td")
    public List<WebElement> row3;
    @FindBy(xpath = "//table//tbody//tr[4]//td")
    public List<WebElement> row4;

}
