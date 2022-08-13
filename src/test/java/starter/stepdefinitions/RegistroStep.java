package starter.stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import starter.registro.Registrarse;

public class RegistroStep {

    @Managed(driver = "appium")
    private AppiumDriver driver;
    @Given("{actor} tiene acceso a la app Mpos por primera vez")
    public void elvis_tiene_acceso_a_la_app_mpos_por_primera_vez(Actor actor) {
        actor.can(
                BrowseTheWeb.with(driver)
        );

    }
    @When("{actor} inicia el registro en la App con el numero de telefono {string}")
    public void el_inicia_el_registro_en_la_app_con_el_numero_de_telefono(Actor actor, String numeroTelefonico) {
        actor.attemptsTo(
                Registrarse.conNumeroTelefonico(numeroTelefonico)
        );

    }

}
