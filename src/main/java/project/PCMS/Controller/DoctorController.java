package project.PCMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.PCMS.Model.CounsellingSession;
import project.PCMS.Repository.BookCounsellingSessionRepository;

@Controller
public class DoctorController {

    @Autowired
    BookCounsellingSessionRepository cousellingrepo;

    @PostMapping("/doctor/acceptsession")
    public String assigncounselling(@RequestParam("counsellingsessionId")Long counsellingsessionId,
                                    @RequestParam("doctorid")Long doctorId, Model model){

        
        CounsellingSession CS = cousellingrepo.getReferenceById(counsellingsessionId);
        System.out.println(CS);


        return "doctordashboard";
    }
    @GetMapping("/report")
    public String report(){
        
        return "viewReport";
    }
}
