package project.PCMS.Model;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;

@Entity
@Table
public class SharingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phoneNo")
    private String phoneNo;

    @Column(name = "time")
    private String time;

    @Column(name = "date")
    private String date;

    @Column(name = "address")
    private String address;

    @Column(name = "detail")
    private String detail;

    public SharingSession() {
    }
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

