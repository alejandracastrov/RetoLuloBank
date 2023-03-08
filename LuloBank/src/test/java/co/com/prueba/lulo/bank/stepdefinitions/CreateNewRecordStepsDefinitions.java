package co.com.prueba.lulo.bank.stepdefinitions;



import co.com.prueba.lulo.bank.models.RegisterUserInfo;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import co.com.prueba.lulo.bank.taks.RegisterNewRecord;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;



public class CreateNewRecordStepsDefinitions {
    @When("you create the employee information with {string} and {string} and {string}")
    public void youCreateTheInformationRequiredToGetTheNewDataOfAnEmployee(String lastName,String firstName,String email)  {
        RegisterUserInfo data = new RegisterUserInfo();
        data.setLastName(lastName);
        data.setFirstName(firstName);
        data.setEmail(email);

        theActorInTheSpotlight().attemptsTo(RegisterNewRecord.info(data));
    }


    @Then("you need to validate the created data of the employee")
    public void youNeedToValidateTheCreatedDataOfTheEmployee()  {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(200)));
    }


    @Then("you need to validate employee already exists")
    public void youNeedToValidateEmployeeAlreadyExists()  {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(400).body("data.email",equalTo("Email already used"))));
    }


}
