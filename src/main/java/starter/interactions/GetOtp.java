package starter.interactions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetOtp implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = ((WebDriverFacade) BrowseTheWeb.as(actor).getDriver()).getProxiedDriver();
        ((AndroidDriver) driver).openNotifications();
        final Target OTPElement = Target.the("Notificacion SMS")
                .locatedForAndroid(By.id("android:id/message_text"))
                .locatedForIOS(By.xpath(""));

        String otpMessage = OTPElement.resolveFor(actor).getText();
        String OTP = StringUtils.substringAfter(otpMessage, "PIN code");
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        actor.remember("codigoOTP", OTP);
    }

    public static GetOtp fromSMS() {
        return Tasks.instrumented(GetOtp.class);
    }
}
