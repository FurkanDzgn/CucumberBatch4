$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/APIFiles/GetPet.feature");
formatter.feature({
  "name": "Getting and deserializing pet from petstore",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "get pet",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "contentType head is set to \"application/json\"",
  "keyword": "Given "
});
formatter.step({
  "name": "user executes GET request",
  "keyword": "When "
});
formatter.step({
  "name": "the status code is OK",
  "keyword": "Then "
});
formatter.step({
  "name": "contentType header is \"application/json\"",
  "keyword": "And "
});
formatter.step({
  "name": "users verfied \u003cid\u003e, \"\u003cname\u003e\", \u003ctags\u003e size",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "id",
        "name",
        "tags"
      ]
    },
    {
      "cells": [
        "10",
        "doggie",
        "1"
      ]
    }
  ]
});
formatter.scenario({
  "name": "get pet",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "contentType head is set to \"application/json\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.API.PetStoreSteps.contenttypeHeadIsSetTo(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user executes GET request",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.API.PetStoreSteps.userExecutesGETRequest(java.lang.String)"
});
formatter.result({
  "error_message": "io.cucumber.core.exception.CucumberException: Step [user executes GET request] is defined with 1 parameters at \u0027StepDefinitions.API.PetStoreSteps.userExecutesGETRequest(java.lang.String)\u0027.\nHowever, the gherkin step has 0 arguments.\nStep text: user executes GET request\r\n\tat io.cucumber.core.runner.PickleStepDefinitionMatch.arityMismatch(PickleStepDefinitionMatch.java:134)\r\n\tat io.cucumber.core.runner.PickleStepDefinitionMatch.runStep(PickleStepDefinitionMatch.java:42)\r\n\tat io.cucumber.core.runner.TestStep.executeStep(TestStep.java:64)\r\n\tat io.cucumber.core.runner.TestStep.run(TestStep.java:49)\r\n\tat io.cucumber.core.runner.PickleStepTestStep.run(PickleStepTestStep.java:46)\r\n\tat io.cucumber.core.runner.TestCase.run(TestCase.java:51)\r\n\tat io.cucumber.core.runner.Runner.runPickle(Runner.java:67)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:149)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:83)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:24)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:185)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:83)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:219)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)\r\n\tat com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)\r\n\tat com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "the status code is OK",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.API.PetStoreSteps.theStatusCodeIsOK()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "contentType header is \"application/json\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.API.PetStoreSteps.contenttypeHeaderIs(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "users verfied 10, \"doggie\", 1 size",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.API.PetStoreSteps.usersVerfiedDoggieSize(java.lang.Integer,java.lang.String,java.lang.Integer)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});