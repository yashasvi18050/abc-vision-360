package com.example.mca118057.adminvision360;

public class Admin {
    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getGender2() {
        return gender2;
    }

    public void setGender2(String gender2) {
        this.gender2 = gender2;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String name2;
    String gender2;
    String contactNo;
    String email;

    public Admin(){

    }
    public Admin(String name2,String gender2,String contactNo,String email){
        this.name2=name2;
        this.gender2=gender2;
        this.contactNo=contactNo;
        this.email=email;
    }

}
