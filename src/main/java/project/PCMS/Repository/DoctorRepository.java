package project.PCMS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.PCMS.Model.Doctor;

@Repository
    public interface DoctorRepository extends JpaRepository<Doctor, Long> {

        Doctor findByUsernameAndPassword(String username, String password);
    
    List<Doctor> findAll();
    void deleteDoctorById(int id);
    Doctor getDoctorById(int id);

    
    }

