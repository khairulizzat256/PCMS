package project.PCMS.Controller.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import jakarta.servlet.http.HttpServletRequest;
=======
>>>>>>> 621035a3ddf69727038f42594fe8a58c38a31bf3
@Controller

public class LoginController {
   
    //startup auto login page
    @GetMapping("/")
    public String login() {
        return "login";
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

    }
    

