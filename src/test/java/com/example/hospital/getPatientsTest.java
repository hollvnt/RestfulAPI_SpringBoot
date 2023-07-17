package com.example.hospital;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class getPatientsTest {
    @Test
    void getPatientsTest(){
        RestAssured
                .given()
                .log().all()
                .get("http://localhost:8091/patients")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    void getPatientsByIdTest(){
        RestAssured
                .given()
                .log().all()
                .get("http://localhost:8091/patients/1")
                .then()
                .log().all()
                .statusCode(200);
    }
}
