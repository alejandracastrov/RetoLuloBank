package co.com.prueba.lulo.bank.questions;


import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class ResponseBody implements Question {

    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().equals("message: Successfully! Record has been added.");
    }
}
