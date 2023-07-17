package com.example.hospital.Facade;
import com.example.hospital.DTO.PatientDTO;
import com.example.hospital.Entity.Patient;
import com.example.hospital.Interfaces.PatientFacade;
import com.example.hospital.Interfaces.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PatientFacadeImpl implements PatientFacade{
    private final PatientService patientService;

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = mapDtoToEntity(patientDTO);
        patient = patientService.createPatient(patient);
        return mapEntityToDto(patient);

    }

    @Override
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientService.getPatientById(id);
        return mapEntityToDto(patient);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return patients.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public void deletePatient(Long id) {
        patientService.deletePatient(id);
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO updatedPatient) {
        Patient patient = mapDtoToEntity(updatedPatient);
        patient = patientService.updatePatient(id, patient);
        return mapEntityToDto(patient);
    }

    private Patient mapDtoToEntity(PatientDTO patientDTO){
        return Patient.builder()
                .name(patientDTO.getName())
                .gender(patientDTO.getGender())
                .age(patientDTO.getAge())
                .phone(patientDTO   .getPhone())
                .build();
    }

    private PatientDTO mapEntityToDto(Patient patient){
        return PatientDTO.builder()
                .name(patient.getName())
                .gender(patient.getGender())
                .age(patient.getAge())
                .phone(patient.getPhone())
                .build();
    }
}
