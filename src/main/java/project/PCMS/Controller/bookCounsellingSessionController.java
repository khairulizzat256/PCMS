package project.PCMS.Controller;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;
import project.PCMS.Model.CounsellingSession;
import project.PCMS.Model.Patient;
import project.PCMS.Repository.BookCounsellingSessionRepository;
import project.PCMS.Repository.PatientRepository;

@Controller
@SessionAttributes("patient")
public class bookCounsellingSessionController {
    
    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    private final BookCounsellingSessionRepository bookCounsellingSessionRepository;

    public bookCounsellingSessionController(PatientRepository patientRepository,
            BookCounsellingSessionRepository bookCounsellingSessionRepository) {
        this.patientRepository = patientRepository;
        this.bookCounsellingSessionRepository = bookCounsellingSessionRepository;
    }

    @GetMapping("/bookSessionForm/{id}")
    public String bookCounsellingForm(@PathVariable("id")Long id, Model model) {
        Patient patient = patientRepository.findById(id).get();
        model.addAttribute("patient", patient);
        model.addAttribute("counsellingSession", new CounsellingSession());
        return "bookCounsellingForm";
    }

    @PostMapping("/bookSessionForm/submit")
    public String bookCounsellingSession(@ModelAttribute("patient") Patient patient
        ,@RequestParam("fullname")String fullname
        ,@RequestParam("phoneNo")String phoneNo
        ,@RequestParam("time")String time
        ,@RequestParam("date")Date date
        ,@RequestParam("reason")String reason, Model model) {
        
        CounsellingSession counsellingSession = new CounsellingSession();
        counsellingSession.setFullname(fullname);
        counsellingSession.setPhoneNo(phoneNo);
        counsellingSession.setTime(Time.valueOf(time));
        counsellingSession.setDate(date);
        counsellingSession.setReason(reason);
        bookCounsellingSessionRepository.save(counsellingSession);
        return "index";
    }
}