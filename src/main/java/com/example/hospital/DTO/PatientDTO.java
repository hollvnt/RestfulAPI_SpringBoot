package com.example.hospital.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientDTO {
    private String name;
    private String gender;
    private int age;
    private String phone;
}
