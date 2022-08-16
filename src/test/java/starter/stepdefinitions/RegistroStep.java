package starter.stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import starter.intro.Completar;
import starter.registro.Registrarse;
import starter.registro.RegistroUI;

import java.time.Duration;

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
        actor.remember("numero telefonico", numeroTelefonico);

    }

    @Then("{actor} deberia poder ver que el mensaje de envio del codigo SMS contine el numero registrado por el usuario")
    public void elvisDeberiaPoderVerQueElMensajeDeEnvioDelCodigoSMSContineElNumeroRegistradoPorElUsuario(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(RegistroUI.TITULO_CODIGO_SMS, WebElementStateMatchers.isPresent())
                        .forNoMoreThan(Duration.ofSeconds(15)),
                Ensure.that(RegistroUI.TITULO_CODIGO_SMS).isDisplayed(),
                Ensure.that(RegistroUI.MENSAJE_ENVIO_SMS)
                        .text()
                        .contains("Escribe el c\u00F3digo que enviamos al n\u00FAmero ".concat(actor.recall("numero telefonico")))
        );
    }

    @Then("{actor} deberia poder ver que el mensaje de error {string}")
    public void elvisDeberiaPoderVerQueElMensajeDeError(Actor actor,String mensajeError) {
        actor.attemptsTo(
                Ensure.that(RegistroUI.MENSAJE_ERROR_TELEFONO).text().isEqualToIgnoringCase("El n\u00FAmero es inv\u00E1lido")
        );
    }
}
