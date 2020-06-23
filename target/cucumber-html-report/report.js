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
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "the demoUser enters username \"Tester\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.com.weborder.LoginPageSteps.the_demoUser_enters_username(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "the demoUser enters password \"test\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.com.weborder.LoginPageSteps.the_demoUser_enters_password(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "the demoUser clicks the login Button",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.com.weborder.LoginPageSteps.the_demoUser_clicks_the_login_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks the allProducs button",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.com.weborder.NewOrderSteps.the_user_clicks_the_allProducs_button()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "the user calidate the product details",
  "rows": [
    {},
    {},
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.com.weborder.NewOrderSteps.the_user_calidate_the_product_details(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});