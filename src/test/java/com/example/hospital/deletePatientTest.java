    package com.example.hospital;

    import io.restassured.RestAssured;
    import org.junit.jupiter.api.Test;
    import org.springframework.boot.test.context.SpringBootTest;

    @SpringBootTest
    public class deletePatientTest {
        @Test
        void deletePatientTest(){
            RestAssured
                    .given()
                    .log().all()
                    .delete("http://localhost:8091/patients/delete/1")
                    .then()
                    .log().all()
                    .statusCode(204);
        }
    }
