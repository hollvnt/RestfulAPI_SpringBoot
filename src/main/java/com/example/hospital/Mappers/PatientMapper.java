package com.example.hospital.Mappers;

import com.example.hospital.DTO.PatientDTO;
import com.example.hospital.Entity.Patient;

public class PatientMapper {
    public Patient mapDtoToEntity(PatientDTO patientDTO){
        return Patient.builder()
                .name(patientDTO.getName())
                .gender(patientDTO.getGender())
                .age(patientDTO.getAge())
                .phone(patientDTO   .getPhone())
                .build();
    }

    public PatientDTO mapEntityToDto(Patient patient){
        return PatientDTO.builder()
                .name(patient.getName())
                .gender(patient.getGender())
                .age(patient.getAge())
                .phone(patient.getPhone())
                .build();
    }
}
