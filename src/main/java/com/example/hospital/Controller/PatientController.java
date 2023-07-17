package com.example.hospital.Controller;

import com.example.hospital.DTO.PatientDTO;
import com.example.hospital.Interfaces.PatientFacade;
import com.example.hospital.Interfaces.UserFacade;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {
    private final PatientFacade patientFacade;
    private final UserFacade userFacade;
    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        List<PatientDTO> patients = patientFacade.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    @PostMapping("/create")
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO, HttpServletRequest request) {
        String username = userFacade.getAuthenticatedUsername(request);
        String password = userFacade.getAuthenticatedPassword(request);

        if (username != null && password != null && userFacade.isValidUser(username, password)) {
            try {
                PatientDTO createdPatient = patientFacade.createPatient(patientDTO);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id){
        try{
            PatientDTO patientDTO = patientFacade.getPatientById(id);
            return ResponseEntity.ok(patientDTO);
        }catch (Exception e){
            return (ResponseEntity<PatientDTO>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO){
        try {
            PatientDTO updatedPatient = patientFacade.updatePatient(id, patientDTO);
            return ResponseEntity.ok(updatedPatient);
        }catch (Exception e){
            return (ResponseEntity<PatientDTO>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PatientDTO> deletePatient(@PathVariable Long id){
        try{
            patientFacade.deletePatient(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return (ResponseEntity<PatientDTO>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
