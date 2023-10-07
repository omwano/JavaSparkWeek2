import org.junit.*;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import static spark.Spark.*;
public class HeroSquadTest {
    private TestClient testClient;
     @BeforeClass
    public static void setUp() {
         Spark.port(4567);
         HeroSquad.main(null);

     }
}
