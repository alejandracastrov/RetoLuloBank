package co.com.prueba.lulo.bank.taks;

import co.com.prueba.lulo.bank.models.RegisterUserInfo;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class RegisterNewRecord implements Task {

    private RegisterUserInfo data;

    public RegisterNewRecord(RegisterUserInfo data) {
        this.data = data;
    }

    @Override
    @Step("{0} consume service user/create")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("user/create").with(
                requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .header("app-id","640768bf9985da2dc047cc6a")
                        .body(data)
                        .log()
                        .all()

        ));
        lastResponse().peek();
    }

    public static Performable info(RegisterUserInfo data) {
        return Tasks.instrumented(RegisterNewRecord.class, data);
    }
}
