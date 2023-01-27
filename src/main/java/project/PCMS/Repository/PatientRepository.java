package project.PCMS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.PCMS.Model.Patient;

@Repository
    public interface PatientRepository extends JpaRepository<Patient, Long> {

        Patient findByUsernameAndPassword(String username, String password);

        List<Patient> findAll();
    }

