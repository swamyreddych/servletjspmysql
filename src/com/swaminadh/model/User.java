package com.swaminadh.model;

import java.util.Date;

public class User {
private int userid ;
private String fname;
private String lname;
private String email;
private Date  dob;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String toString() {
    return "User [userid=" + userid + ", fName=" + fname
            + ", lName=" + lname + ", dob=" + dob + ", email="
            + email + "]";
}    


}
