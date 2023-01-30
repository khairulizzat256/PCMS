package project.PCMS.Repository;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.PCMS.Model.CounsellingSession;

@Repository
public interface BookCounsellingSessionRepository extends JpaRepository<CounsellingSession, Long>{

    java.util.List<CounsellingSession> findAllByAssignedDoctor(String string);
   
    CounsellingSession getCounsellingSessionById(int id);
    java.util.List<CounsellingSession> findByAssignedDoctorAndStatus(String assignedDoctor, String status);
    void deleteCounsellingSessionById(int id);

    
}



