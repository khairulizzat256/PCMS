package project.PCMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.PCMS.Model.CounsellingSession;
import project.PCMS.Model.Doctor;
import project.PCMS.Repository.BookCounsellingSessionRepository;

@Controller
public class DoctorController {

    @Autowired
    private BookCounsellingSessionRepository counsellingrepo;

    @PostMapping("/doctor/acceptsession")
    public String assigncounselling(@RequestParam("counsellingsessionId")Long counsellingsessionId,
                                    @ModelAttribute("counsellingsession") Doctor doctor, Model model){

        
        CounsellingSession CS = counsellingrepo.getReferenceById(counsellingsessionId);
        String drname = doctor.getfullname();
        CS.setAssignedDoctor(drname);
        counsellingrepo.save(CS);
       
        List<CounsellingSession> counsellingSessions = counsellingrepo.findAllByAssignedDoctor("");
        model.addAttribute("counsellingSessions", counsellingSessions);
        model.addAttribute("doctor", doctor);


        return "doctordashboard";
    }
    
}
