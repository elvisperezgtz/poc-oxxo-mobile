package starter.api;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.assertj.core.util.Files;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.nio.file.Paths;

@RunWith(SerenityRunner.class)
public class GetName {

    private Actor actor;

    @Before
    public void setUp(){
        Cast cast = Cast.whereEveryoneCan(CallAnApi.at("https://rickandmortyapi.com"));
        actor = cast.actorNamed("Rest client");
    }

    @Test
    public void query(){
        actor.attemptsTo(Post.to("/graphql").with(query->{
            query.contentType(ContentType.JSON);
            return  query.body(
                    Files.contentOf(
                            Paths.get(
                                    (this.getClass().getResource("query.json").getPath())).toFile(),"UTF-8"
            ));
        }));

    }
}
