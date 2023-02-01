package project.PCMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import project.PCMS.Model.Report;
@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{

    List<Report> findAll();   
    List<Report> findByAssignedDoctorAndStatus(String assignedDoctor, String status);
    
}
