package project.PCMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/patient/edit/{id}")
    public String editPatient(@PathVariable("id") Long id, Model model) {
    Patient patient = patientRepository.findById(id).get();
    List<Patient> patients = patientRepository.findAll();
    model.addAttribute("patients", patients);
    model.addAttribute("edituser",patient);

    return "admindashboard";
}

    @PostMapping("/patient/update")
    public String updatePatient(@ModelAttribute Patient patient) {
    patientRepository.save(patient);
    return "admindashboard";
}
    


}
