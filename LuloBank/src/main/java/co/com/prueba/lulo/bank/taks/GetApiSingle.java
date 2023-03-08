package co.com.prueba.lulo.bank.taks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;





        public class GetApiSingle implements Task {

    public GetApiSingle(String id) {
        this.id = id;
    }

            @Step("{0} executes a GET with id #id")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("user/{id}").with(
                requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .pathParams("id",id)
                        .header("app-id","640768bf9985da2dc047cc6a")
                        .log()
                        .all()
                )
        );
        lastResponse().peek();
    }

    public static GetApiSingle getApi() {
        return Tasks.instrumented(GetApiSingle.class);
    }

            public static Performable Info(String id) {
                return Tasks.instrumented(GetApiSingle.class, id);
            }


    private String id;
}
