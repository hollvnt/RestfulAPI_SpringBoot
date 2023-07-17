package com.example.hospital;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class loginUserTest {
    private SessionFilter sessionFilter;

    @BeforeEach
    public void setUp() {
        sessionFilter = new SessionFilter();
    }

    @Test
    void loginTest() {
        String userJson = "{ \"username\": \"Igor\", \"password\": \"1337\" }";

        RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(userJson)
                .filter(sessionFilter)
                .post("http://localhost:8091/login")
                .then()
                .statusCode(200);
    }
}
