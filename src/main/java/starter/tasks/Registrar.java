package starter.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.interactions.GetOtp;

public class Registrar {
    public static ElNumeroTelefonico elNumeroTelefonico(String numeroTelefonico) {
        return Tasks.instrumented(ElNumeroTelefonico.class, numeroTelefonico);
    }

    public static Performable elNumeroTelefonicoYContrasenia(String numeroTelefonico, String contrasenia){
        return Task.where(
                "{0} completa el registro con su usuario y contrasenia",
                Completar.elTutorial(),
                GetOtp.fromSMS(),
                Registrar.elNumeroTelefonico(numeroTelefonico),

             //   Ingresar.codigoDeValidacion(OnStage.theActorInTheSpotlight().recall("codigoOTP").toString()),
                Ingresar.unaContrasenia(contrasenia)
        );
    }
}
