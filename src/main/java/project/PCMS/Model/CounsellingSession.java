package project.PCMS.Model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CounsellingSession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phoneNo")
    private String phoneNo;

    @Column(name = "time")
    private Time time;

    @Column(name = "date")
    private Date date;

    @Column(name = "reason")
    private String reason;

    @Column(name = "status")
    private String status = "unassigned";

    @Column(name = "assignedDoctor", columnDefinition = "varchar(255) default ''")
    private String assignedDoctor = "";


    public CounsellingSession(int id, String fullname, String phoneNo, Time time, Date date, String reason, String status,
    String assignedDoctor) {
        this.id = id;
        this.fullname = fullname;
        this.phoneNo = phoneNo;
        this.time = time;
        this.date = date;
        this.reason = reason;
        this.status = status;
        this.assignedDoctor = assignedDoctor;
}
    

    public CounsellingSession(String fullname, String phoneNo, Time time, Date date, String reason, String status,
            String assignedDoctor) {
        this.fullname = fullname;
        this.phoneNo = phoneNo;
        this.time = time;
        this.date = date;
        this.reason = reason;
        this.status = status;
        this.assignedDoctor = assignedDoctor;
    }


    public CounsellingSession() {
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getAssignedDoctor() {
        return assignedDoctor;
    }


    public void setAssignedDoctor(String assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }


    @Override
    public String toString() {
        return "CounsellingSession [id=" + id + ", fullname=" + fullname + ", phoneNo=" + phoneNo + ", time=" + time
                + ", date=" + date + ", reason=" + reason + ", status=" + status + ", assignedDoctor=" + assignedDoctor
                + "]";
    }

    
    
}
