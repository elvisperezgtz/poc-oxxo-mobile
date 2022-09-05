package starter.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.interactions.Esperar;
import starter.interactions.SelectFromDropDown;
import starter.models.Usuario;
import starter.user_interfaces.DatosPersonalesUI;
import starter.user_interfaces.RegistroUI;

import java.io.IOException;
import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.user_interfaces.DatosPersonalesUI.*;
import static starter.user_interfaces.PasswordUI.CONTRASENIA;
import static starter.user_interfaces.PasswordUI.TITULO;
import static starter.user_interfaces.RegistroUI.REENVIAR_SMS;

public class Ingresar {

    private String codigoValidacion;

    public Ingresar(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public static Performable codigoDeValidacion(String codigoValidacion) throws IOException {

        return Task.where("{0} ingresa el codigo OTP que le llego a su linea movil",
                Enter.theValue(String.valueOf(codigoValidacion.charAt(0))).into(RegistroUI.CASILLA1_OTP),
                Enter.theValue(String.valueOf(codigoValidacion.charAt(1))).into(RegistroUI.CASILLA2_OTP),
                Enter.theValue(String.valueOf(codigoValidacion.charAt(2))).into(RegistroUI.CASILLA3_OTP),
                Enter.theValue(String.valueOf(codigoValidacion.charAt(3))).into(RegistroUI.CASILLA4_OTP),
                Enter.theValue(String.valueOf(codigoValidacion.charAt(4))).into(RegistroUI.CASILLA5_OTP),
                Enter.theValue(String.valueOf(codigoValidacion.charAt(5))).into(RegistroUI.CASILLA6_OTP)
        );
    }

    public static Performable unNuevoCodigoDeVerificacion() throws IOException {

        return Task.where("{0} ingresa un nuevo codigo de validacion",
                Esperar.queTermineLaCuentaRegresiva(),
                Click.on(REENVIAR_SMS)
//                Ingresar.codigoDeValidacion()
        );
    }

    public static Performable unaContrasenia(String contrasenia) {
        return Task.where("{0} ingresa una contraseña para su cuenta",
                WaitUntil.the(TITULO, isPresent()).forNoMoreThan(ofSeconds(5))
                        .then(Enter.theValue(contrasenia).into(CONTRASENIA))
        );
    }

    public static Performable datosPersonales(Usuario usuario) {
        return Task.where("{0} llena el formulario de datos personales",
                WaitUntil.the(DatosPersonalesUI.TITULO, isVisible()).forNoMoreThan(ofSeconds(15)),
                Enter.theValue(usuario.getNombre()).into(NOMBRES),
                Enter.theValue(usuario.getApellido()).into(PRIMER_APELLIDO),
                Enter.theValue(usuario.getEmail()).into(EMAIL),
                Enter.theValue(usuario.getNombreNegocio()).into(NOMBRE_DE_TU_NEGOCIO),
                SelectFromDropDown.byVisibleText(ACTIVIDAD_DE_TU_NEGOCIO, usuario.getActividadEconomica()),
                Enter.theValue(usuario.getCodigoPostal()).into(CODIGO_POSTAL)
        );

    }
}
