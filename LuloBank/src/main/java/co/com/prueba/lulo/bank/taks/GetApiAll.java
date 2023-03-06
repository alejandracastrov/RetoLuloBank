package co.com.prueba.lulo.bank.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class GetApiAll implements Task {

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("/api/v1/employees"));
    }

    public static GetApiAll getApi() {
        return Tasks.instrumented(GetApiAll.class);
    }
}
