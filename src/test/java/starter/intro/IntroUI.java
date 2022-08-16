package starter.intro;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IntroUI {
    public static final Target CONTINUAR = Target.the("boton continuar")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='ONBOARDING_COLUMN_BUTTONS']/android.view.View/android.widget.Button"))
            .locatedForIOS(By.xpath(""));

    public static final Target TITULO = Target.the("titulo pantalla inicio")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc='ONBOARDING_TEXT_TITLE']"))
            .locatedForIOS(By.xpath(""));

}
