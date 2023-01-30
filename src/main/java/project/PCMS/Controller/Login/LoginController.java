package project.PCMS.Controller.Login;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.PCMS.Model.Admin;
import project.PCMS.Model.CounsellingSession;
import project.PCMS.Model.Doctor;
import project.PCMS.Model.Patient;
import project.PCMS.Repository.AdminRepository;
import project.PCMS.Repository.BookCounsellingSessionRepository;
import project.PCMS.Repository.DoctorRepository;
import project.PCMS.Repository.PatientRepository;

@Controller

public class LoginController {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    BookCounsellingSessionRepository bookCounsellingSessionRepository;
   
    //startup auto login page
    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/loginadmin")
    public String loginadmin() {
        
        return "loginadmin";
    }


    @PostMapping("/loginPatientcheck")
    public String loginPatientcheck(@RequestParam String username, @RequestParam String password, Model model){
       


        //get username and password in database of Patient table
        Patient patient = patientRepository.findByUsernameAndPassword(username, password);
        
        if (patient == null) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
        else{
            model.addAttribute("patient", patient);
            System.out.print("-------------------" + patient);
            return "index";
        }
        
    }

    @PostMapping("/admindashboard")
    public String loginadmincheck(@RequestParam String username, @RequestParam String password, Model model) {
       
        //get username and password in database of Admin table
        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
        
        if (admin == null) {
            model.addAttribute("error", "Invalid username or password");
            return "loginadmin";
        }

        List<Patient> patients = patientRepository.findAll();
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("patients", patients);
        model.addAttribute("doctors",doctors);
        return "admindashboard";
        
    }

    @PostMapping("/logindoctorcheck")
    public String logindoctorcheck(@RequestParam String username, @RequestParam String password, Model model) {       
        //get username and password in database of Doctor table
        Doctor doctor = doctorRepository.findByUsernameAndPassword(username, password);
        
        if (doctor == null) {
            model.addAttribute("error", "Invalid username or password");
            return "logindoctor";
        }
        
        List<CounsellingSession> counsellingSessions = bookCounsellingSessionRepository.findAllByAssignedDoctor("");
        model.addAttribute("counsellingSessions", counsellingSessions);
        model.addAttribute("doctor", doctor);
        return "doctordashboard";
        
    }
        
    

    @GetMapping("/logindoctor")
    public String logindoctor() {
        return "logindoctor";
    }
    
    /**
     * @return
     */
    @PostMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/register")
    public String registerpatient(){
        return "register";
    }
    @RequestMapping("/createclient")
    public String createclient(){
        return "create_client";
    }
    }
    

