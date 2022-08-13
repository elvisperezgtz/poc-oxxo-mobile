package starter.registro;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.home.HomeUI;
import starter.intro.Completar;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class Registrarse {
    public static Performable conNumeroTelefonico(String numeroTelefonico) {
        return Task.where("{0} se registra en la app con el numero telefonico " + numeroTelefonico,
                Completar.elTutorial(),
                Click.on(HomeUI.EMPEZAR_REGISTRO),
                Enter.theValue(numeroTelefonico).into(RegistroUI.TELEFONO.waitingForNoMoreThan(ofSeconds(15))),
                Click.on(RegistroUI.ACEPTO),
                Click.on(RegistroUI.ENVIAR_CODIGO_SMS)
        );

    }
}
