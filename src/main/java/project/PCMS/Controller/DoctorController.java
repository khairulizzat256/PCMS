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
       
        CS.setAssignedDoctor(doctor.getfullname());
        CS.setStatus("assigned");
        counsellingrepo.save(CS);
       
        List<CounsellingSession> counsellingSessions = counsellingrepo.findAllByAssignedDoctor("");
        model.addAttribute("counsellingSessions", counsellingSessions);
        model.addAttribute("doctor", doctor);


        return "doctordashboard";
    }

    @GetMapping("/doctor/viewschedule")
    public String viewschedule(@ModelAttribute("doctorId") Long doctorid, Model model) {       
       

        Doctor doctor = doctorrepository.getReferenceById(doctorid);
        List<CounsellingSession> counsellingSessions = counsellingrepo.findByAssignedDoctorAndStatus(doctor.getfullname(),"assigned");
        model.addAttribute("counsellingSessions", counsellingSessions);
        model.addAttribute("doctor", doctor);
        return "schedule";
        
    }


    @GetMapping("/report")
    public String report(){
        
        return "viewReport";
    }
}
