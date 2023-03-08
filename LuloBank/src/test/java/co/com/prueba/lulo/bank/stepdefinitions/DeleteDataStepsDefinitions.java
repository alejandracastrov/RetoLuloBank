package co.com.prueba.lulo.bank.stepdefinitions;


import co.com.prueba.lulo.bank.models.RegisterUserInfo;
import co.com.prueba.lulo.bank.taks.DeleteDataApi;
import co.com.prueba.lulo.bank.taks.RegisterNewRecord;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.IsEqual.equalTo;


public class DeleteDataStepsDefinitions {
    @When("he sends the necessary information to delete the record")
    public void heSendsTheNecessaryInformationToDeleteTheRecord()  {
        theActorInTheSpotlight().attemptsTo(DeleteDataApi.Info("60d0fe4f5311236168a109d9"));
    }


    @Then("he should get a deleted record in the database")
    public void heShouldGetADeletedRecordInTheDatabase()  {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(200)));
    }

    @Then("he validates that the id does not exist")
    public void heValidatesthattheIddoesnotExist ()  {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(400).body("error",equalTo("PARAMS_NOT_VALID"))));
    }
}
