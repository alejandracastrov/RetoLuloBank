package co.com.prueba.lulo.bank.stepdefinitions;

import co.com.prueba.lulo.bank.exceptions.StatusCodeException;
import co.com.prueba.lulo.bank.questions.ResponseCode;
import co.com.prueba.lulo.bank.taks.GetApiAll;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
//import net.serenitybdd.screenplay.rest.abiities.CallAnApi;


import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;
import static co.com.prueba.lulo.bank.util.ReadPropertiesFile.getInstance;

public class GetAllDataStepsDefinitions {


    @Given("^Andres wants to be able to test common API verbs$")
    public void andresWantsToBeAbleToTestCommonAPIVerbs() throws Exception {
        setTheStage(new OnlineCast());
        theActorCalled("Andres");
       // theActorInTheSpotlight().whoCan(CallAnApi.at(getInstance().getUrl()));
    }

    @When("^he consults the information required to obtain the data of the employees$")
    public void heConsultsTheInformationRequiredToObtainTheDataOfTheEmployees() throws Exception {
        theActorInTheSpotlight().attemptsTo(GetApiAll.getApi());
    }

    @Then("^he must obtain the data of all employees$")
    public void heMustObtainTheDataOfAllEmployees() throws Exception {
        theActorInTheSpotlight().should(seeThat( new ResponseCode(), equalTo(200)).orComplainWith(StatusCodeException.class));
    }
}
