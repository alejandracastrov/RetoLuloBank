package co.com.prueba.lulo.bank.taks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class GetApiSingle implements Task {

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("/api/v1/employee/1").with(
                requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)));
    }

    public static GetApiSingle getApi() {
        return Tasks.instrumented(GetApiSingle.class);
    }


}
