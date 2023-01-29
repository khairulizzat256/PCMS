package project.PCMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.PCMS.Model.CounsellingSession;

@Repository
public interface BookCounsellingSessionRepository extends JpaRepository<CounsellingSession, Long>{


    
}
