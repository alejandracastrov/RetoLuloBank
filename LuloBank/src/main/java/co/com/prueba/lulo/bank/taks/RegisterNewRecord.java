package co.com.prueba.lulo.bank.taks;

import co.com.prueba.lulo.bank.models.RegisterUserInfo;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;


public class RegisterNewRecord implements Task {

    private RegisterUserInfo data;

    public RegisterNewRecord(RegisterUserInfo data) {
        this.data = data;
    }


    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/api/v1/create").with(
                requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(data)
        ));
    }

    public static Performable Info(RegisterUserInfo data) {
        return Tasks.instrumented(RegisterNewRecord.class, data);
    }
}
