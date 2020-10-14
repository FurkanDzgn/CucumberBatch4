package Applitools;

import Pages.Amazon.HomePageAmazon;
import org.junit.Test;

public class ExecuteTestCase1 extends InitializeCase1 {

    HomePageAmazon homePageAmazon = new HomePageAmazon(driver);

    @Test
    public void case1() throws InterruptedException {
        driver.get("https://www.google.com/");
//        homePageAmazon.searchBox.sendKeys("iphone");
//        homePageAmazon.searchButton.click();
        Thread.sleep(2000);
        validateWindow();
    }

}
