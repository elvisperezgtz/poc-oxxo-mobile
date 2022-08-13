package starter.intro;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static starter.intro.IntroUI.CONTINUAR;

public class Completar {
    public static Performable elTutorial (){
        return Task.where("{0} completa el tutorial introductorio",
                Click.on(CONTINUAR),
                Click.on(CONTINUAR)
        );
    }
}
