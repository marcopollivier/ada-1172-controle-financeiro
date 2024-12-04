package br.com.ada.t1172.ControleFinanceiro.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }


    @Test
    public void shouldAddAndGetUser() {
        given()
            .body("""
                {
                    "name": "marco",
                    "email": "marco@gmail.com"
                }
            """)
            .contentType("application/json")
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("marco"));

        when()
                .get("/api/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("marco"))
                .body("email", equalTo("marco@gmail.com"));
    }

    @Test
    public void shouldReturnNotFoundForInvalidUser() {
        given()
                .when()
                .get("/api/users/999")
                .then()
                .statusCode(404);
    }
}
