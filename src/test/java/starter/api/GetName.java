package starter.api;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import netscape.javascript.JSObject;
import org.assertj.core.util.Files;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.nio.file.Paths;

@RunWith(SerenityRunner.class)
public class GetName {

    private Actor actor;

    @Before
    public void setUp() {
        Cast cast = Cast.whereEveryoneCan(CallAnApi.at("https://backend.digitalb2b.dev/"));
        actor = cast.actorNamed("Rest client");
    }


    @Test
    public void query() {
        String bodyQuery = "{\n" +
                "                    \"query\": \"mutation SendOtp($request: OtpSendRequest) {\\n  sendOtp(request: $request) {\\n    status\\n    message\\n  }\\n}\\n\",\n" +
                "                    \"variables\": {\n" +
                "                \"request\": { \"countryCode\": \"+57\", \"mobileNumber\": \"3046169952\" }\n" +
                "            },\n" +
                "            \"operationName\": \"SendOtp\"\n" +
                "}";
//
//
//        return actor.attemptsTo(Post.to("/")
//                .with(query -> {
//                    query.contentType(ContentType.JSON);
//                    return query.body(bodyQuery);
//                }
//    ;});
    }
}