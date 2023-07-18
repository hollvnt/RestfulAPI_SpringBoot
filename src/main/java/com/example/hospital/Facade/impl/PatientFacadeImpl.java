package com.example.hospital.Facade.impl;
import com.example.hospital.DTO.PatientDTO;
import com.example.hospital.Entity.Patient;
import com.example.hospital.Facade.PatientFacade;
import com.example.hospital.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.hospital.Mappers.PatientMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PatientFacadeImpl implements PatientFacade{
    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.mapDtoToEntity(patientDTO);
        patient = patientService.createPatient(patient);
        return patientMapper.mapEntityToDto(patient);

    }

    @Override
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientService.getPatientById(id);
        return patientMapper.mapEntityToDto(patient);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return patients.stream()
                .map(patientMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }


    @Override
    public void deletePatient(Long id) {
        patientService.deletePatient(id);
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO updatedPatient) {
        Patient patient = patientMapper.mapDtoToEntity(updatedPatient);
        patient = patientService.updatePatient(id, patient);
        return patientMapper.mapEntityToDto(patient);
    }

}
