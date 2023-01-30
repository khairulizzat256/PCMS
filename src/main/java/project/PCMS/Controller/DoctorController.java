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
import project.PCMS.Repository.DoctorRepository;

@Controller
public class DoctorController {

    @Autowired
    private BookCounsellingSessionRepository counsellingrepo;

    @Autowired
    private DoctorRepository doctorrepository;

    @PostMapping("/doctor/acceptsession")
    public String assigncounselling(@RequestParam("counsellingsessionId")Long counsellingsessionId,
                                    @ModelAttribute("doctor") Long doctorid, Model model){

        
        CounsellingSession CS = counsellingrepo.getReferenceById(counsellingsessionId);
        Doctor doctor = doctorrepository.getReferenceById(doctorid);
        System.out.println(CS.getFullname());
        System.out.println(doctor.getfullname());
        CS.setAssignedDoctor(doctor.getfullname());
        CS.setStatus("assigned");
        counsellingrepo.save(CS);
       
        List<CounsellingSession> counsellingSessions = counsellingrepo.findAllByAssignedDoctor("");
        model.addAttribute("counsellingSessions", counsellingSessions);
        model.addAttribute("doctor", doctor);


        return "doctordashboard";
    }
    
}
