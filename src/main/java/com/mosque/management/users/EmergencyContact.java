package com.mosque.management.users;

import java.sql.Date;

public class EmergencyContact implements Person {
    private String firstName;
    private String lastName;
    private java.sql.Date doB;
    private String email;
    private String address;
    private String telNo;
    public EmergencyContact(String firstName, String lastName, java.sql.Date doB,
                            String email, String address,String telNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.doB = doB;
        this.email = email;
        this.address = address;
        this.telNo = telNo;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Date getDoB() {
        return this.doB;
    }

    @Override
    public void setDoB(java.sql.Date doB) {
        System.out.println(this.doB);
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getTelNo() {
        return telNo;
    }

    @Override
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    public String toString(){
        return "Name : " + this.firstName + " " + this.lastName + "\n" +
                "Email : " + this.email + "\n" +
                "Date of birth : " + this.doB + "\n" +
                "Telephone number : " + this.telNo + "\n" +
                "Address : " + this.address + "\n" ;
    }

}
