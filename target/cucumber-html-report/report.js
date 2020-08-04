$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/com.WebOrder/ProductDataTable.feature");
formatter.feature({
  "name": ": All Products",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validation of All products",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the demoUser enters username \"Tester\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.com.weborder.LoginPageSteps.the_demoUser_enters_username(java.lang.String)"
});
