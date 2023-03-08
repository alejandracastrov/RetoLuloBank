package co.com.prueba.lulo.bank.taks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class GetApiAll implements Task {

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("user").with(
        requestSpecification -> requestSpecification
                .header("app-id","640768bf9985da2dc047cc6a")
                .log()
                .all()
        )
        );

        lastResponse().peek();
    }


    public static GetApiAll getApi() {
        return Tasks.instrumented(GetApiAll.class);
    }
}
