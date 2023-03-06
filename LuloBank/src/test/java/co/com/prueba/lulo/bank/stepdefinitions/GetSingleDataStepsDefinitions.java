package co.com.prueba.lulo.bank.stepdefinitions;

import co.com.prueba.lulo.bank.exceptions.StatusCodeException;
import co.com.prueba.lulo.bank.questions.ResponseCode;
import co.com.prueba.lulo.bank.taks.GetApiSingle;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;


public class GetSingleDataStepsDefinitions {

    @When("^he consult the information required to obtain the data of an employee$")
    public void heConsultTheInformationRequiredToObtainTheDataOfAnEmployee() throws Exception {
        theActorInTheSpotlight().attemptsTo(GetApiSingle.getApi());
    }


    @Then("^he need to get the employee data$")
    public void heNeedToGetTheEmployeeData() throws Exception {
        theActorInTheSpotlight().should(seeThat( new ResponseCode(), equalTo(200)).orComplainWith(StatusCodeException.class));
    }
}
