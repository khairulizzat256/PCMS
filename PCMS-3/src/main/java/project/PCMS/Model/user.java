package project.PCMS.Model;


public class user {

private String username;
private String fullname;
private String phoneNo;
private String password;

public user(String username,String fullname, String phoneNo, String password) {

this.username = username;
this.fullname = fullname;
this.phoneNo = phoneNo;
this.password = password;
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
return "user [ fullname=" + fullname + ", phoneNo=" + phoneNo + ", password=" + password + "]";









}
}