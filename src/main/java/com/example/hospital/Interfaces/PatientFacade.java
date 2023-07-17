package com.example.hospital.Interfaces;

import com.example.hospital.DTO.PatientDTO;

import java.util.List;

public interface PatientFacade {
    PatientDTO createPatient(PatientDTO patientDTO);
    PatientDTO getPatientById(Long id);
    List<PatientDTO> getAllPatients();
    void deletePatient(Long id);
    PatientDTO updatePatient(Long id, PatientDTO updatedPatient);
}
