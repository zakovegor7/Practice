import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchTest {
    @Test
    void patchTest() {

        String body = "Patch";

        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }
}