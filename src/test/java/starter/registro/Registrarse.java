package starter.registro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import starter.home.HomeUI;

import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class Registrarse implements Task {
    private String numeroTelefonico;

    public Registrarse(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    @Step("{0} se registra en la app con el numero telefonico #numeroTelefonico")
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actor.attemptsTo(
                WaitUntil.the(HomeUI.EMPEZAR_REGISTRO, isClickable()).forNoMoreThan(ofSeconds(15)),
                Click.on(HomeUI.EMPEZAR_REGISTRO),
                Enter.theValue(numeroTelefonico).into(RegistroUI.TELEFONO.waitingForNoMoreThan(ofSeconds(15))),
                Click.on(RegistroUI.ACEPTO),
                Click.on(RegistroUI.ENVIAR_CODIGO_SMS)
        );
    }
    public static Registrarse conNumeroTelefonico(String numeroTelefonico){
        return Tasks.instrumented(Registrarse.class, numeroTelefonico);
    }
}
