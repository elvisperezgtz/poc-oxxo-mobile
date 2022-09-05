package starter.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroUI {
        public static final Target PREFIJO = Target.the("Campo prefijo")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='REGISTERPHONENUMBER_COLUMN_PHONENUMBER']/android.widget.EditText[1]/android.view.View[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target TELEFONO = Target.the("Campo telefono")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='REGISTERPHONENUMBER_COLUMN_PHONENUMBER']/android.widget.EditText[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target ACEPTO = Target.the("checkbox Acepto aviso de privacidad")
            .locatedForAndroid(By.xpath("//android.widget.CheckBox[@content-desc='REGISTERPHONENUMBER_CHECKBOX_TERMSANDCONDITIONS']"))
            .locatedForIOS(By.xpath(""));

    public static final Target ENVIAR_CODIGO_SMS = Target.the("checkbox Acepto aviso de privacidad")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Enviar c\u00F3digo por SMS']"))
            .locatedForIOS(By.xpath(""));

    public static final Target MENSAJE_ENVIO_SMS = Target.the("mensaje de confirmacion del envio del sms")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc='TEXT_SUBTITLE']"))
            .locatedForIOS(By.xpath(""));

    public static final Target TITULO_CODIGO_SMS = Target.the("titulo codigo sms")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'C\u00F3digo SMS')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target MENSAJE_ERROR_TELEFONO = Target.the("mensaje de error del campo telefono")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc='OUTLINE_TEXTFIELD']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CELULAR_VALIDADO = Target.the("mensaje de confirmacion 'Celular validado'")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_MESSAGE_VALIDATION']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CODIGO_INCORRECTO = Target.the("mensaje codigo incorrecto")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_COLUMN_CONTAINER']/android.widget.TextView"))
            .locatedForIOS(By.xpath(""));

    public static final Target  CASILLA1_OTP= Target.the("casilla 1 de verificacion")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_ROW_CONTAINER']/android.widget.EditText[1]"))
            .locatedForIOS(By.xpath(""));

 public static final Target  CASILLA2_OTP= Target.the("casilla 2 de verificacion")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_ROW_CONTAINER']/android.widget.EditText[2]"))
            .locatedForIOS(By.xpath(""));

  public static final Target  CASILLA3_OTP= Target.the("casilla 3 de verificacion")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_ROW_CONTAINER']/android.widget.EditText[3]"))
            .locatedForIOS(By.xpath(""));

  public static final Target  CASILLA4_OTP= Target.the("casilla 4 de verificacion")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_ROW_CONTAINER']/android.widget.EditText[4]"))
            .locatedForIOS(By.xpath(""));

  public static final Target  CASILLA5_OTP= Target.the("casilla 5 de verificacion")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_ROW_CONTAINER']/android.widget.EditText[5]"))
            .locatedForIOS(By.xpath(""));

  public static final Target  CASILLA6_OTP= Target.the("casilla 6 de verificacion")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_ROW_CONTAINER']/android.widget.EditText[6]"))
            .locatedForIOS(By.xpath(""));

  public static final Target CRONOMETRO= Target.the("cronometro")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_COLUMN_CONTAINER_RESEND']/android.widget.TextView"))
            .locatedForIOS(By.xpath(""));

public static final Target REENVIAR_SMS= Target.the("boton Reenviar SMS")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc='SMSCODE_BUTTON_RESEND']"))
            .locatedForIOS(By.xpath(""));


}
