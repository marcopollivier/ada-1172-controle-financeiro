package br.com.ada.t1172.ControleFinanceiro.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void shouldAddAndGetUser() {
        given()
                .contentType("application/json")
                .body(
                    """ 
                      {
                          "id": 1,
                          "name": "John Doe",
                          "email": "john.doe@example.com"
                      }
                      """)
                .when()
                .post("/users")
                .then()
                .statusCode(201) // Status 201 Created
                .body("id", equalTo(1))
                .body("name", equalTo("John Doe"))
                .body("email", equalTo("john.doe@example.com"));

        given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200) // Status 200 OK
                .body("id", equalTo(1))
                .body("name", equalTo("John Doe"))
                .body("email", equalTo("john.doe@example.com"));
    }

    @Test
    void shouldReturnNotFoundForInvalidUser() {
        given()
                .when()
                .get("/users/999")
                .then()
                .statusCode(404); // Status 404 Not Found para usuário inexistente
    }
}
