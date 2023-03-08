package co.com.prueba.lulo.bank.taks;


import io.restassured.http.ContentType;
import io.restassured.http.Header;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class DeleteDataApi implements Task {


    private String id;
    private  String APP_ID;
    public DeleteDataApi(String id) {
        this.id = id;
    }

    @Step("{0} executes a DELETE with id #id")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Delete.from("user/{id}").with(
                requestSpecification -> requestSpecification
                        .header("app-id","640768bf9985da2dc047cc6a")
                        .contentType(ContentType.JSON)
                        .pathParams("id",id)
                        .log()
                        .all()

                )
        );
        lastResponse().peek();
    }

    public static Performable Info(String id) {
        return Tasks.instrumented(DeleteDataApi.class, id);
    }
}
