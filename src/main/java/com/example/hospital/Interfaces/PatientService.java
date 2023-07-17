package com.example.hospital.Interfaces;

import com.example.hospital.Entity.Patient;

import java.util.List;

public interface PatientService {
    Patient createPatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    void deletePatient(Long id);
    Patient updatePatient(Long id, Patient updatedPatient);
}
