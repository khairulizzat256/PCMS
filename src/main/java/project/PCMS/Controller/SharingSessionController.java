package project.PCMS.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.sql.Time;
import java.util.Date;

import project.DButil.bookingsharingsessionDao;
import project.PCMS.Model.SharingSession;

@Controller
public class SharingSessionController {
    
    @GetMapping("/sharingsession")
    public String sharingSession() {
        return "booksharingsessionform";
    }

    @PostMapping("/createsharingsession")
    public String createSharingSession(HttpServletRequest request) {
        
        String fullname = request.getParameter("fullname");
        String phoneNo = request.getParameter("phoneNo");
        
        String time = request.getParameter("time");
        String date = request.getParameter("date");
        String address= request.getParameter("address");
        String detail= request.getParameter("details");
        
        SharingSession sharingsession = new SharingSession(fullname, phoneNo, time, date, address, detail);

        sharingsession.setfullname(fullname);
        sharingsession.setphoneNo(phoneNo);
        sharingsession.settime(time);
        sharingsession.setdate(date);
        sharingsession.setaddress(address);
        sharingsession.setdetail(detail);
        
       

        bookingsharingsessionDao bookingsharingsessionDao = new bookingsharingsessionDao();
        int row = bookingsharingsessionDao.create(sharingsession);
        System.out.println("row affected: " + row);
        return "booksharingsessionform";

        
    }
}
