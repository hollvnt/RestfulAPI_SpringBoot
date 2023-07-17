package com.example.hospital;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class registerUserTest {
    @Test
    void registerUserTest(){
        String userJson = "{ \"username\": \"Igor\", \"password\": \"1337\" }";

        RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(userJson)
                .log().all()
                .when()
                .post("http://localhost:8091/register")
                .then()
                .log().all()
                .statusCode(201);

    }
}
