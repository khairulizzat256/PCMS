package project.PCMS.Model;

import java.sql.Time;
import java.util.Date;

public class SharingSession {
    private String fullname;
    private String phoneNo;
    private String time;
    private String date;
    private String address;
    private String detail;
    
    public SharingSession(String fullname, String phoneNo, String time, String date, String address, String detail) {
        this.fullname = fullname;
        this.phoneNo = phoneNo;
        this.time = time;
        this.date = date;
        this.address = address;
        this.detail = detail;
        
    }

    public String getfullname() {
        return fullname;
    }

    public void setfullname(String fullname) {
        this.fullname = fullname;
    }

    public String getphoneNo() {
        return phoneNo;
    }

    public void setphoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getdetail() {
        return detail;
    }

    public void setdetail(String detail) {
        this.detail = detail;
    }
    @Override
    public String toString() {
        return "SharingSession [fullname=" + fullname + ", phoneNo=" + phoneNo + ", time=" + time + ", date=" + date + ", address=" + address + ", detail=" + detail + "]";
    }
}

