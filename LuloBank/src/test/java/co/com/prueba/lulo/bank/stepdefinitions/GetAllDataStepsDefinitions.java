package co.com.prueba.lulo.bank.stepdefinitions;

import co.com.prueba.lulo.bank.exceptions.StatusCodeException;
import co.com.prueba.lulo.bank.questions.ResponseCode;
import co.com.prueba.lulo.bank.taks.GetApiAll;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.io.IOException;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;
import static co.com.prueba.lulo.bank.util.ReadPropertiesFile.getInstance;

public class GetAllDataStepsDefinitions {


    @Given("{word} wants to be able to test common API verbs")
    public void WantsToBeAbleToTestCommonAPIVerbs(String nameActor) throws IOException {
        setTheStage(new OnlineCast());
        theActorCalled(nameActor);
        theActorInTheSpotlight().whoCan(CallAnApi.at(getInstance().getUrl()));
    }

    @When("he consults the information required to obtain the data of the employees")
    public void heConsultsTheInformationRequiredToObtainTheDataOfTheEmployees() {
        theActorInTheSpotlight().attemptsTo(GetApiAll.getApi());
    }

    @Then("he must obtain the data of all employees")
    public void heMustObtainTheDataOfAllEmployees() {
        theActorInTheSpotlight().should(seeThat(new ResponseCode(), equalTo(200)).orComplainWith(StatusCodeException.class));
    }
}
