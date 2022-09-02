package starter.stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import starter.interactions.GetOtp;
import starter.models.Usuario;
import starter.tasks.Ingresar;
import starter.tasks.Registrar;
import starter.user_interfaces.IntroDispositivoUI;

import static starter.user_interfaces.DatosPersonalesUI.CONTINUAR;
import static starter.user_interfaces.IntroDispositivoUI.TITULO;

public class CapturaDatosPersonalesSteps {
    @Managed(driver = "appium")
    private AppiumDriver driver;

    public Usuario usuario = new Usuario();

    @Given("{actor} ha registrado el telefono {string} y establecio la contrasenia {string}")
    public void elvisHaRegistradoElTelefonoYEstablecioLaContrasenia(Actor actor, String telefono, String contrasenia) {

        actor.attemptsTo(
                GetOtp.fromSMS()
              //  Registrar.elNumeroTelefonicoYContrasenia(telefono, contrasenia)
        );
    }

    @When("{actor} registra los datos personales")
    public void elvisRegistraLosDatosPersonales(Actor actor) {
        usuario.defaulValues();
        actor.attemptsTo(
                Ingresar.datosPersonales(usuario),
                Click.on(CONTINUAR)
        );
    }

    @Then("{actor} deberia poder ver el titulo {string}")
    public void elvisDeberiaPoderVerElTitulo(Actor actor, String titulo) {
        actor.attemptsTo(
                Ensure.that(TITULO).text().isEqualTo(titulo)
        );
    }

    @And("{actor} deberia ver los botones con el texto {string} y {string}")
    public void elvisDeberiaVerLosBotonesConElTextoY(Actor actor, String botonYaLoTengo, String botonAunNoLoTengo) {
        actor.attemptsTo(
                Ensure.that(IntroDispositivoUI.YA_LO_TENGO).text().isEqualTo(botonYaLoTengo),
                Ensure.that(IntroDispositivoUI.AUN_NO_LO_TENGO).text().isEqualTo(botonAunNoLoTengo)
        );
    }
}
