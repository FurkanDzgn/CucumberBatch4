package Pages.WebOrderPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    // If i dont have nullPointerException
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="ctl00_logout")
    public WebElement logOutButton;

    @FindBy(className="login_info")
    public WebElement welcomeText;

    @FindBy(xpath = "//a[.='Order']")
    public WebElement orderButton;

    @FindBy(xpath = "//a[.='View all orders']")
    public WebElement ViewAllOrdersButton;

    @FindBy(xpath = "//a[.='View all products']")
    public WebElement viewAllProductButton;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr")
    public List<WebElement> productTable;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr//*")
    public List<WebElement> getProductTable;
}
