package project.PCMS.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.DButil.userDao;
import project.PCMS.Model.user;

@Controller
@RequestMapping("/user")
public class userController {
  
   @GetMapping("/register")
      public String user_Register() {
         return "register";
      }
   
   @PostMapping("/createuser")
   public String register(HttpServletRequest request)
   {
      String username = request.getParameter("username");
       String fullname = request.getParameter("fullname");
       String phoneNo = request.getParameter("phoneNo");
       String password = request.getParameter("password");
       user user = new user(username,fullname, phoneNo, password);
       
       user.setusername(username);
       user.setfullname(fullname);
       user.setphoneNo(phoneNo);
       user.setpassword(password);

      userDao userDao = new userDao();
      int row = userDao.create(user);
      System.out.println("row affected: " + row);
      return "login";

       }

       }

    

        
    
    
    

