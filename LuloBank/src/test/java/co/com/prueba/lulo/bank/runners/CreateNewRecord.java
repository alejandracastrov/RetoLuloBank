package co.com.prueba.lulo.bank.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/create_new_record.feature",
        glue = "co.com.prueba.lulo.bank.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class CreateNewRecord {
}
