package starter.registro;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroUI {
        public static final Target PREFIJO = Target.the("Campo prefijo")
            .locatedForAndroid(By.xpath("\t\n" +
                    "//android.view.View[@content-desc=\"REGISTERPHONENUMBER_COLUMN_PHONENUMBER\"]/android.widget.EditText[1]/android.view.View[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target TELEFONO = Target.the("Campo telefono")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='REGISTERPHONENUMBER_COLUMN_PHONENUMBER']/android.widget.EditText[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target ACEPTO = Target.the("checkbox Acepto aviso de privacidad")
            .locatedForAndroid(By.xpath("//android.widget.CheckBox[@content-desc=\"REGISTERPHONENUMBER_CHECKBOX_TERMSANDCONDITIONS\"]"))
            .locatedForIOS(By.xpath(""));
    public static final Target ENVIAR_CODIGO_SMS = Target.the("checkbox Acepto aviso de privacidad")
            .locatedForAndroid(By.xpath("//android.widget.CheckBox[@content-desc=\"REGISTERPHONENUMBER_CHECKBOX_TERMSANDCONDITIONS\"]"))
            .locatedForIOS(By.xpath(""));


}
