package co.com.prueba.lulo.bank.stepdefinitions;


import co.com.prueba.lulo.bank.models.RegisterUserInfo;
import co.com.prueba.lulo.bank.taks.DeleteDataApi;
import co.com.prueba.lulo.bank.taks.RegisterNewRecord;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.IsEqual.equalTo;


public class DeleteDataStepsDefinitions {
    @When("^he sends the necessary information to delete the record$")
    public void heSendsTheNecessaryInformationToDeleteTheRecord() throws Exception {
        theActorInTheSpotlight().attemptsTo(DeleteDataApi.Info(344));
    }


    @Then("^he should get a deleted record in the database$")
    public void heShouldGetADeletedRecordInTheDatabase() throws Exception {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(200).body("message",equalTo("Successfully! Record has been deleted"))));
    }
}
