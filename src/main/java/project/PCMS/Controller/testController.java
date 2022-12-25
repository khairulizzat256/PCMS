package project.PCMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class testController {
    
    //startup auto login page
    @GetMapping("/")
    public String loginstart() {
        return "login";
    }
    
    @PostMapping("/index")
    public String index(){
        return "index";
    }
    
}
