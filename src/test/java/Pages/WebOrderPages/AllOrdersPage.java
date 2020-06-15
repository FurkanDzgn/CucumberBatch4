package Pages.WebOrderPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllOrdersPage {

    public AllOrdersPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")
    public List<WebElement> newOrderDetails;


}
