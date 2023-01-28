package project.PCMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.PCMS.Model.Doctor;

@Repository
    public interface DoctorRepository extends JpaRepository<Doctor, Long> {

        Doctor findByUsernameAndPassword(String username, String password);
    }

