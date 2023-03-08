package co.com.prueba.lulo.bank.stepdefinitions;

import co.com.prueba.lulo.bank.taks.GetApiSingle;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.IsEqual.equalTo;


public class PutDataStepsDefinitions {

    @When("he put the information required to obtain the data of an employee")
    public void hePuttInformationRequiredtoObtaintheDataofanEmployee () {
        theActorInTheSpotlight().attemptsTo(GetApiSingle.Info("60d0fe4f5311236168a109ca"));
    }


    @Then("he need to put the employee data")
    public void heNeedToGetTheEmployeeData()  {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(200)));
    }
    @Then("he need to put the name of employee")
    public void  heNeedToPutTheNameofEmployee()  {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(400).body("error",equalTo("PARAMS_NOT_VALID"))));
    }

}
