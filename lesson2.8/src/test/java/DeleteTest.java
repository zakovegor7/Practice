import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteTest {

    @Test
    void deleteTest() {

        given()
                .baseUri("https://postman-echo.com")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}