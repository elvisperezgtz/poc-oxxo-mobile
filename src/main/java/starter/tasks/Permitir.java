package starter.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.user_interfaces.VinculacionUI;

import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.user_interfaces.IntroDispositivoUI.*;

public class Permitir {
    public static Performable activarBlueTooth() {
        return Task.where("{0} permite activar el Bluetooth",
                WaitUntil
                        .the(TITULO_SOLICITUD_ACTIVACION_BT, isVisible())
                        .forNoMoreThan(ofSeconds(10))
                        .then(Click.on(PERMITIR_ACTIVACION_BT))
        );
    }

    public static Performable usarUbicacion() {
        return Task.where(
                "{0} permite el uso de la ubicacion",
                WaitUntil
                        .the(TITULO_PERMITIR_UBICACION, isVisible())
                        .forNoMoreThan(ofSeconds(10))
                        .then(Click.on(VinculacionUI.MIENTRAS_LA_APP_ESTA_EN_USO))
        );
    }

}
