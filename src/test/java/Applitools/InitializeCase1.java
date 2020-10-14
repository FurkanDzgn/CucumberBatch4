package Applitools;

import Utils.ConfigReader;
import Utils.Driver;
import com.applitools.eyes.selenium.Eyes;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class InitializeCase1 {

    public static WebDriver driver = Driver.getDriver();
    public static Eyes eyes;

    @BeforeClass
    public static void setEyes(){
        initiateEyes();
    }

    @AfterClass
    public static void tearSetEyes(){
        eyes.abortIfNotClosed();
    }

    private static void initiateEyes() {
        eyes = new Eyes();
        eyes.setApiKey(ConfigReader.getProperty("applitools"));

    }

    public static void validateWindow(){
        eyes.open(driver, "Automation Test3",
                Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();
    }

}
