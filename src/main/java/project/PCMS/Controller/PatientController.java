package project.PCMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.PCMS.Model.Patient;
import project.PCMS.Repository.PatientRepository;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/createpatient")
    public String createpatient(@RequestParam("username")String username
    ,@RequestParam("fullname")String fullname
    ,@RequestParam("phoneNo")String phoneNo
    ,@RequestParam("password")String password,Model model){

        Patient patient = new Patient();

        patient.setusername(username);
        patient.setfullname(fullname);
        patient.setpassword(password);
        patient.setphoneNo(phoneNo);

        patientRepository.save(patient);
        
        model.addAttribute("successMessage", "Patient registered successfully!");
        return "login";
        
    }


    @PostMapping("/update")
    public String updatePatient(@ModelAttribute Patient patientnew, Model model) {

    model.addAttribute("successMessage", "Patient updated successfully!");
    Patient patientold = patientRepository.getPatientById(patientnew.getId());
    patientold.setusername(patientnew.getusername());
    patientold.setfullname(patientnew.getfullname());
    patientold.setphoneNo(patientnew.getphoneNo());
    patientold.setpassword(patientnew.getpassword());
    patientRepository.save(patientold);
        
    
    return "admindashboard";
    }
}
