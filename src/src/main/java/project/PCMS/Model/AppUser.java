package project.PCMS.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class AppUser {
  
    @Id
    private Long id;
}
