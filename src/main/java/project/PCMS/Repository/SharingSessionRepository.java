package project.PCMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import project.PCMS.Model.SharingSession;
@Repository
public interface SharingSessionRepository extends JpaRepository<SharingSession, Long>{

    List<SharingSession> findAll();
    SharingSession getSharingSessionById(int id);
    void deleteSharingSessionById(int id);
    
   
    
}
