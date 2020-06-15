package StepDefinitions;

import Utils.BrowserUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.SortedMap;

public class Hooks {

    // We have  before and after annotations.
    // Those are coming from the  Cucumber.
    // will run before and after each scenario
    // We have one Scenario interface to get the details from every scenario

    @Before
    public void setUp(Scenario scenario){
        System.out.println("This one will run before each scenario");
        System.out.println(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("This one will run after each scenario");
        // after annotation will execute after each scenario even though they are failed, undefined.
        if(scenario.isFailed()){
       //    scenario.log(scenario.getName()+" is failed");
            System.out.println("failed");
            // if some feature files line and stepDefinion class console gives us error
            // There is a problem here
            BrowserUtils.takeScreenShot();
            
        }
    }

    // I am saying run this Before annotation if the scenario has @tt tag
    // conditional
    @Before("@tt") // Logintest.feature
    public void conditionalAnnotattion(){
        // I want to run this annotation only before @conditional tag
        System.out.println("Conditional annotation");
        // It will run only the scenarious which has @conditional tag
    }


}
