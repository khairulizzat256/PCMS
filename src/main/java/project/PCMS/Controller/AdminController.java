package project.PCMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.transaction.Transactional;
import project.PCMS.Model.CounsellingSession;
import project.PCMS.Model.Doctor;
import project.PCMS.Model.Patient;
import project.PCMS.Repository.BookCounsellingSessionRepository;
import project.PCMS.Repository.DoctorRepository;
import project.PCMS.Repository.PatientRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    BookCounsellingSessionRepository bookCounsellingSessionRepository;

    @GetMapping("/admindashboard")
    public String dashboard(Model model){

        List<Patient> patients = patientRepository.findAll();
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("patients", patients);
        model.addAttribute("doctors",doctors);
        return "admindashboard";
    }
    
    @GetMapping("/viewclient")
    public String user_manage(Model model){

        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "user_client";
    }

    @GetMapping("/viewpsychologist")
    public String viewpsychologist(Model model){
        
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors",doctors);
        return "user_psychologist";
    }
    @GetMapping("/form")
    public String createclient(){
        return "create_client";
    }

    @GetMapping("/form1")
    public String createpsychologist(){
        return "create_psychologist";
    }


   @PostMapping("/createclient")
   public String createclient(@RequestParam("username")String username
    ,@RequestParam("fullname")String fullname
    ,@RequestParam("phoneNo")String phoneNo
    ,@RequestParam("password")String password,Model model){

        Patient patient = new Patient();

        patient.setusername(username);
        patient.setfullname(fullname);
        patient.setpassword(password);
        patient.setphoneNo(phoneNo);

        patientRepository.save(patient);

        List<Patient> patients = patientRepository.findAll();
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("patients", patients);
        model.addAttribute("doctors",doctors);

        return "redirect:/admin/admindashboard";
    }

    @PostMapping("/createpsychologist")
    public String createPsychologist(@RequestParam("username")String username
     ,@RequestParam("fullname")String fullname
     ,@RequestParam("phoneNo")String phoneNo
     ,@RequestParam("password")String password,Model model){
 
         Doctor doctor = new Doctor();
 
         doctor.setusername(username);
         doctor.setfullname(fullname);
         doctor.setpassword(password);
         doctor.setphoneNo(phoneNo);
 
         doctorRepository.save(doctor);

        List<Patient> patients = patientRepository.findAll();
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("patients", patients);
        model.addAttribute("doctors",doctors);
        return "redirect:/admin/admindashboard";
     }
     @Transactional
     @GetMapping("/delete/{id}")
	public String deletePatient(@PathVariable int id, Model model) {
	    patientRepository.deletePatientById(id);

        List<Patient> patients = patientRepository.findAll();
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("patients", patients);
        model.addAttribute("doctors",doctors);
		return "redirect:/admin/admindashboard";
	}
    @Transactional
     @GetMapping("/delete1/{id}")
	public String deleteDoctor(@PathVariable int id,Model model) {
	    doctorRepository.deleteDoctorById(id);

        List<Patient> patients = patientRepository.findAll();
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("patients", patients);
        model.addAttribute("doctors",doctors);
        return "redirect:/admin/admindashboard";
	}


    @GetMapping("/patient/edit/{id}")
    public String editPatient(@PathVariable("id") Long id, Model model) {
    Patient patient = patientRepository.findById(id).get();
    List<Patient> patients = patientRepository.findAll();
     model.addAttribute("patients", patients);
    model.addAttribute("edituser",patient);
    

    return "admindashboard";
}

    @GetMapping("sessionlist")
    public String sessionlist(Model model){
        List<CounsellingSession> sessions = bookCounsellingSessionRepository.findAll();
        model.addAttribute("sessions", sessions);

        return "adminsessionlist";
    }

}

  


    



