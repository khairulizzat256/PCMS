package project.PCMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.PCMS.Model.Admin;

@Repository
    public interface AdminRepository extends JpaRepository<Admin, Long> {
        
        Admin findByUsernameAndPassword(String username, String password);
    }

