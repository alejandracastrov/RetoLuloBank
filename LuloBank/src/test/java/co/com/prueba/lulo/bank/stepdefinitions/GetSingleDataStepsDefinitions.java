package co.com.prueba.lulo.bank.stepdefinitions;

import co.com.prueba.lulo.bank.exceptions.StatusCodeException;
import co.com.prueba.lulo.bank.questions.ResponseCode;
import co.com.prueba.lulo.bank.taks.DeleteDataApi;
import co.com.prueba.lulo.bank.taks.GetApiSingle;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.IsEqual.equalTo;


public class GetSingleDataStepsDefinitions {

    @When("he consult the information required to obtain the data of an employee")
    public void heConsultTheInformationRequiredToObtainTheDataOfAnEmployee()  {
        theActorInTheSpotlight().attemptsTo(GetApiSingle.Info("60d0fe4f5311236168a109ca"));
    }


    @Then("he need to get the employee data")
    public void heNeedToGetTheEmployeeData()  {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(200)));
    }
    @Then("you need to validate an employee that does not exist")
    public void youNeedToValidateanEmployeethatdoesnotExist  (){
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(400)));
    }
}
