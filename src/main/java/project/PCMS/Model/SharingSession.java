package project.PCMS.Model;

import java.sql.Time;
import java.util.Date;

public class SharingSession {
    private String fullname;
    private String phoneNo;
    private Time time;
    private Date date;
    private String address;
    private String detail;
    
    public SharingSession(String fullname, String phoneNo, Time time, Date date, String address, String detail) {
        this.fullname = fullname;
        this.phoneNo = phoneNo;
        this.time = time;
        this.date = date;
        this.address = address;
        this.detail = detail;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
