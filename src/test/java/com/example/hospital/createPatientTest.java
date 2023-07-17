package com.example.hospital;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class createPatientTest {

    @Test
    void loginAndCreatePatientTest() {
        String userJson = "{ \"username\": \"Igor\", \"password\": \"1337\" }";
        String patientJson = "{ \"name\": \"Marix\", \"gender\": \"male\", \"age\": 21, \"phone\": \"123123\" }";

        // Вход и получение куков
        String loginCookie = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(userJson)
                .post("http://localhost:8091/login")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response()
                .getCookie("login");// Получаем значение куки

        String passwordCookie = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(userJson)
                .post("http://localhost:8091/login")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response()
                .getCookie("password"); // Получаем значение куки

        // Используем куки для создания пациента
        RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .cookie("login", loginCookie)
                .cookie("password", passwordCookie)
                .body(patientJson)
                .log().all()
                .post("http://localhost:8091/patients/create")
                .then()
                .log().all()
                .statusCode(201);
    }

    }
