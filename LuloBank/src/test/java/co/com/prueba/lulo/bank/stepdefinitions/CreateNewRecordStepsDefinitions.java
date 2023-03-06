package co.com.prueba.lulo.bank.stepdefinitions;



import co.com.prueba.lulo.bank.models.RegisterUserInfo;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import co.com.prueba.lulo.bank.taks.RegisterNewRecord;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;



public class CreateNewRecordStepsDefinitions {
    @When("^you create the information required to get the new data of an employee$")
    public void youCreateTheInformationRequiredToGetTheNewDataOfAnEmployee() throws Exception {
        RegisterUserInfo data = new RegisterUserInfo();
        data.setName("Andres");
        data.setAge(30);
        data.setSalary(5000000);
        data.getId();
        theActorInTheSpotlight().attemptsTo(RegisterNewRecord.Info(data));
    }


    @Then("^you need to validate the created data of the employee.$")
    public void youNeedToValidateTheCreatedDataOfTheEmployee() throws Exception {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(200).body("message",equalTo("Successfully! Record has been added."))));
    }
}
