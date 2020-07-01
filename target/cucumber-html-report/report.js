$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/APIFiles/CreatePet.feature");
formatter.feature({
  "name": "Api First scenario",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Api"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Api POST scenario",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user creates a pet with \"\u003cid\u003e\", \"\u003cname\u003e\", \"\u003cstatus\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "name": "pet with \"\u003cid\u003e\", \"\u003cname\u003e\", \"\u003cstatus\u003e\" is created",
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
        "status"
      ]
    },
    {
      "cells": [
        "123456",
        "Kumar",
        "available"
      ]
    },
    {
      "cells": [
        "234335",
        "Patel",
        "do not touch"
      ]
    },
    {
      "cells": [
        "23424",
        "Jack",
        "busy"
      ]
    },
    {
      "cells": [
        "24253235",
        "Pikachu",
        "messy"
      ]
    },
    {
      "cells": [
        "225235",
        "Frank",
        "busy"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Api POST scenario",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Api"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user creates a pet with \"123456\", \"Kumar\", \"available\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.user_creates_a_pet_with(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.the_status_code_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pet with \"123456\", \"Kumar\", \"available\" is created",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.pet_with_is_created(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Api POST scenario",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Api"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user creates a pet with \"234335\", \"Patel\", \"do not touch\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.user_creates_a_pet_with(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.the_status_code_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pet with \"234335\", \"Patel\", \"do not touch\" is created",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.pet_with_is_created(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Api POST scenario",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Api"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user creates a pet with \"23424\", \"Jack\", \"busy\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.user_creates_a_pet_with(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.the_status_code_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pet with \"23424\", \"Jack\", \"busy\" is created",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.pet_with_is_created(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Api POST scenario",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Api"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user creates a pet with \"24253235\", \"Pikachu\", \"messy\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.user_creates_a_pet_with(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.the_status_code_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pet with \"24253235\", \"Pikachu\", \"messy\" is created",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.pet_with_is_created(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Api POST scenario",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Api"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user creates a pet with \"225235\", \"Frank\", \"busy\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.user_creates_a_pet_with(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.the_status_code_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pet with \"225235\", \"Frank\", \"busy\" is created",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.API.ApiStepDef.pet_with_is_created(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});