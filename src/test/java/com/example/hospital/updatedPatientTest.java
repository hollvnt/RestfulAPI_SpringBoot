package com.example.hospital;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class updatedPatientTest {
    @Test
    void updatedPatientTest(){

        String updatedPatientJson = "{ \"name\": \"Olya\", \"gender\": \"female\", \"age\": 30, \"phone\": \"987654321\" }";

        RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .log().all()
                .body(updatedPatientJson)
                .put("http://localhost:8091/patients/update/1")
                .then()
                .log().all()
                .statusCode(200);


    }
}
