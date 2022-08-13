package starter.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.interactions.touch.TouchActions;

public class Scroll implements Interaction {

    private Target element;

    public Scroll(Target element) {
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        TouchActions action = new TouchActions(BrowseTheWeb.as(actor).getDriver());
        action.scroll(element.resolveFor(actor), 50, 100);
        action.perform();
    }

    public static Scroll untilTheElementIsPresent(Target element) {
        return Tasks.instrumented(Scroll.class, element);
    }
}
