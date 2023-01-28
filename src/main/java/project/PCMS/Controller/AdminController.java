package project.PCMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.PCMS.Model.Doctor;
import project.PCMS.Model.Patient;
import project.PCMS.Repository.DoctorRepository;
import project.PCMS.Repository.PatientRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @RequestMapping("/viewpsychologist")
    public String viewpsychologist(Model model){
        
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors",doctors);
        return "admindashboard";
    }

    @RequestMapping("/viewclient")
    public String viewclient(Model model){

        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "admindashboard";
    }
    


}
