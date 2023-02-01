package project.PCMS.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.PCMS.Model.Doctor;
import project.PCMS.Model.Patient;
import project.PCMS.Repository.DoctorRepository;
import project.PCMS.Repository.PatientRepository;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorRepository doctorrepository;

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

    
    Patient patientold = patientRepository.getPatientById(patientnew.getId());
    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    System.out.println(patientnew);
    System.out.println(patientold);
    patientold.setusername(patientnew.getusername());
    patientold.setfullname(patientnew.getfullname());
    patientold.setphoneNo(patientnew.getphoneNo());
    patientold.setpassword(patientnew.getpassword());
    patientRepository.save(patientold);
    
    List<Patient> patients = patientRepository.findAll();
    List<Doctor> doctors = doctorRepository.findAll();
        
    model.addAttribute("patients", patients);
        
    model.addAttribute("doctors",doctors);

    model.addAttribute("successMessage", "Patient updated successfully!");
    return "redirect:/admin/admindashboard";
    }

    @GetMapping("/patient/edit/{id}")
    public String editPatient(@PathVariable("id") Long id, Model model) {
    Patient patient = patientRepository.findById(id).get();
    List<Patient> patients = patientRepository.findAll();
     model.addAttribute("patients", patients);
    model.addAttribute("edituser",patient);

    List<Doctor> doctors = doctorrepository.findAll();
    model.addAttribute("doctors", doctors);
    

    return "admindashboard";
    }


    @GetMapping("/updateProfile")
        public String editProfile(Model model, @ModelAttribute ("id")int id){
        Patient patient = patientRepository.getPatientById(id);
        model.addAttribute("patient", patient);
        return "editPatientProfile";
    }

    @PostMapping("/updatePatient/confirm")
        public String submitEditProfile(@ModelAttribute Patient patient, @RequestParam("id") int id, Model model){
        Optional<Patient> patientOptional = patientRepository.findById((long)id);
        if (patientOptional.isPresent()) {
            Patient patientToUpdate = patientOptional.get();
            patientToUpdate.setId(id);
            patientToUpdate.setusername(patient.getusername());
            patientToUpdate.setfullname(patient.getfullname());
            patientToUpdate.setphoneNo(patient.getphoneNo());
            patientRepository.save(patientToUpdate);



            Patient patientnew = patientRepository.getReferenceById((long)id);
            model.addAttribute("patient", patientnew);
            model.addAttribute("update", "update");
        }
        return "index";
    }
}
