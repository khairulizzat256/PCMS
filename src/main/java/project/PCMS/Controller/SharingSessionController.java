package project.PCMS.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.Time;
import java.util.Date;


import project.PCMS.Model.Patient;
import project.PCMS.Model.SharingSession;

import project.PCMS.Repository.PatientRepository;
import project.PCMS.Repository.SharingSessionRepository;

@Controller

public class SharingSessionController {

    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    private final SharingSessionRepository SharingSessionRepository;
    

    public SharingSessionController(PatientRepository patientRepository
                                    ,SharingSessionRepository SharingSessionRepository) {
        this.patientRepository = patientRepository;
        this.SharingSessionRepository = SharingSessionRepository;
    }

    @GetMapping("/sharingsession/{id}")
    public String sharingSession(@PathVariable("id")Long id, Model model) { 
        Patient patient= patientRepository.findById(id).get();
        model.addAttribute("patient", patient);
        model.addAttribute("sharingSession",new SharingSession());
        
        return "booksharingsessionform";
    }


    @PostMapping("/createsharingsession")
    public String createSharingSession(@ModelAttribute("patient") Patient patient
                                        ,@RequestParam("fullname")String fullname
                                        ,@RequestParam("phoneNo")String phoneNo
                                        ,@RequestParam("time")String time
                                        ,@RequestParam("date")String date
                                        ,@RequestParam("address")String address
                                        ,@RequestParam("details")String details
                                        ,Model model) {
        
        SharingSession sharingSession = new SharingSession();
        sharingSession.setfullname(fullname);
        sharingSession.setphoneNo(phoneNo);
        sharingSession.settime(time);
        sharingSession.setdate(date);
        sharingSession.setaddress(address);
        sharingSession.setdetail(details);
        SharingSessionRepository.save(sharingSession);
        model.addAttribute("success", "success");
        return "index";
        

        
    }
}

