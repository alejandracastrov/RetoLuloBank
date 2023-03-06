package co.com.prueba.lulo.bank.taks;

import co.com.prueba.lulo.bank.models.RegisterUserInfo;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;



public class DeleteDataApi implements Task {

    private int id;

    public DeleteDataApi(int id) {
        this.id = id;
    }


    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from("/api/v1/delete/2").with(
                requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(id)
                )
        );
    }

    public static Performable Info(int id) {
        return Tasks.instrumented(DeleteDataApi.class, id);
    }
}
