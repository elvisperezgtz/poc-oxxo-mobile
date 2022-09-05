package starter.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.user_interfaces.VinculacionUI.CONECTAR_MPOS;
import static starter.user_interfaces.VinculacionUI.VINCULAR_BT;

public class Conectar {
    public static Performable elDispositivoMpos(){
        return Task.where(
                "{0} se conecta con el dispositivo Mpos",
                WaitUntil.the(CONECTAR_MPOS, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(30))
                        .then(Click.on(CONECTAR_MPOS)),
                Click.on(VINCULAR_BT)
        );
    }
}
