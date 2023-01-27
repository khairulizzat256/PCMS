package project.PCMS.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table  //by default, table name will be as class name
public class Patient {

   

    //id will be auto generate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //define inside the column
    @Column(name = "username")
    private String username;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phoneNo")
    private String phoneNo;

    @Column(name = "password")
    private String password;

    public Patient() {
    }

    public Patient(String username, String fullname, String phoneNo, String password) {
        this.username = username;
        this.fullname = fullname;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
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

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "patient [ fullname=" + fullname + ", phoneNo=" + phoneNo + ", password=" + password + "]";

    }
}