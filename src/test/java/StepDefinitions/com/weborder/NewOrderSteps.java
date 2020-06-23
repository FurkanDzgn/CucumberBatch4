package StepDefinitions.com.weborder;

import Pages.WebOrderPages.AllOrdersPage;
import Pages.WebOrderPages.HomePage;
import Pages.WebOrderPages.OrderPage;
import Utils.BrowserUtils;

import Utils.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class NewOrderSteps {
    WebDriver driver= Driver.getDriver();
    HomePage homePage=new HomePage(driver);
    OrderPage orderPage=new OrderPage(driver);
    AllOrdersPage allOrdersPage=new AllOrdersPage(driver);

    @Then("the user enters product info {string} and {string}")
    public void the_user_enters_product_info_and(String product, String quantity) throws InterruptedException {
        homePage.orderButton.click();
        Select select=new Select(orderPage.productName);
        select.selectByVisibleText(product);

        orderPage.quantity.clear();
        Thread.sleep(500);
        orderPage.quantity.sendKeys(quantity);

    }

    @Then("the user enter address info {string}, {string}, {string}, {string},{string}")
    public void the_user_enter_address_info(String customerName, String street, String city, String state, String zipCode) {

        orderPage.customerName.sendKeys(customerName);
        orderPage.street.sendKeys(street);
        orderPage.city.sendKeys(city);
        orderPage.state.sendKeys(state);
        orderPage.zipCode.sendKeys(zipCode);

    }

    @Then("the user enters payment info {string}, {string}, {string}")
    public void the_user_enters_payment_info(String card, String cardNumber, String expirationDate) {

        switch (card){
            case"Visa":
                orderPage.visaCard.click();
                break;
            case"MasterCard":
                orderPage.masterCard.click();
                break;
            case"American Express":
                orderPage.amexCard.click();
                break;
        }
        orderPage.cardNum.sendKeys(cardNumber);
        orderPage.expDate.sendKeys(expirationDate);
        orderPage.processButton.click();


    }

    @Then("the user validate success message")
    public void the_user_validate_success_message() {
        Assert.assertTrue(orderPage.successMessage.isDisplayed());

    }

    @Then("the user validate new order details {string}, {string}, {string},  {string}, {string}, {string},{string}, {string}, {string}, {string}")
    public void the_user_validate_new_order_details(String ProductName, String quantity, String name, String address, String city, String state, String zipCode, String CardType, String carNumber, String expDate) {

        homePage.ViewAllOrdersButton.click();
        List<WebElement> orderDetails=allOrdersPage.newOrderDetails;
        Assert.assertEquals(name,orderDetails.get(1).getText());
        Assert.assertEquals(ProductName,orderDetails.get(2).getText());
        Assert.assertEquals(quantity,orderDetails.get(3).getText());

        //While we are asserting in JUNIT first Expected and second actual
        //In TestNG first actual then expected
        String today=BrowserUtils.todaysDate("MM/dd/yyyy");
        Assert.assertEquals(today,orderDetails.get(4).getText());
        Assert.assertEquals(address,orderDetails.get(5).getText());
        Assert.assertEquals(city,orderDetails.get(6).getText());
        Assert.assertEquals(state,orderDetails.get(7).getText());
        Assert.assertEquals(zipCode,orderDetails.get(8).getText());
        Assert.assertEquals(CardType,orderDetails.get(9).getText());
        Assert.assertEquals(carNumber,orderDetails.get(10).getText());
        Assert.assertEquals(expDate,orderDetails.get(11).getText());

    }
    @Then("the user goes to the new order page")
    public void the_user_goes_to_the_new_order_page() {
      homePage.orderButton.click();
    }

    @Then("the user validate the product headers")
    public void the_user_validate_the_product_headers(List<String> productHeaders) {

   //     List<String> actualProductHeader=BrowserUtils.getTextOfElement(orderPage.productDetails);
        List<String> actualProductHeader=new ArrayList<>();

        List<WebElement> headers=orderPage.productDetails;
        for(WebElement header:headers){
            actualProductHeader.add(header.getText());
        }

        Assert.assertEquals(productHeaders,actualProductHeader);
    }

    @Then("the user validate the headers for address")
    public void the_user_validate_the_headers_for_address(DataTable dataTable) {
//       // Since it is coming from the feature file.It is expected
//        List<String> expectedAddressHeaders=dataTable.asList();
//
//        List<String> actualAddressHeader=new ArrayList<>();
//        List<WebElement> headers=orderPage.addressDetails;
//        for(WebElement header:headers){
//            actualAddressHeader.add(header.getText());
//        }
//        Assert.assertEquals(expectedAddressHeaders,actualAddressHeader);
//
//        // create the method will take one parameter as List of webelement
//        // return List of String

         List<String> expectedAddressHeaders=dataTable.asList();
         List<String> actualAddressHeader=BrowserUtils.getTextOfElement(orderPage.addressDetails);
        Assert.assertEquals(expectedAddressHeaders,actualAddressHeader);

    }

    @Then("the user clicks the allProducs button")
    public void the_user_clicks_the_allProducs_button() {
        homePage.viewAllProductButton.click();
    }

    @Then("the user calidate the product details")
    public void the_user_calidate_the_product_details(DataTable dataTable) { // io.cucumber.datatable.DataTable dataTable
             // List<String> dataTable-

        List<WebElement> pTable=homePage.getProductTable;
        for (int i=0;i<dataTable.asList().size();i++){
            Assert.assertEquals("Validation of product table",dataTable.asList().get(i),pTable.get(i).getText());
//            System.out.println(dataTable.asList().get(i));
//            System.out.println(pTable.get(i).getText());
        }

//        for(WebElement row:homePage.productTable){
//            System.out.println(row.getText());
//        }


        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
     //   throw new io.cucumber.java.PendingException();
    }



}
