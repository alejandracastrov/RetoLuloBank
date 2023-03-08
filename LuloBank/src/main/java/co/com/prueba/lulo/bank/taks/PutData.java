package co.com.prueba.lulo.bank.taks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;
import org.jetbrains.annotations.NotNull;

import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class PutData implements Task {
    private String id;
public PutData(String id) {
this.id = id;
}

    @Step("{0} executes a GET with id #id")
public <T extends Actor> void performAs(@NotNull T actor) {
        actor.attemptsTo(Put.to("user/{id}").with(
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

public static PutData getApi() {
return Tasks.instrumented(PutData.class);
}

    public static Performable Info(String id) {
        return Tasks.instrumented(PutData.class, id);
    }



}
