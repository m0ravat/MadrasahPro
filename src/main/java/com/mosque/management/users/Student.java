package com.mosque.management.users;

import java.util.Date;

public class Student implements Person{
    private String firstName;
    private String lastName;
    private java.sql.Date doB;
    private String email;
    private String address;
    private String telNo;
    private String username;
    private String password;
    private String allergies;
    private double punctuality;
    private double moneyOwed;
    private double attendance;
    private EmergencyContact emergencyContact;
    public Student(String firstName, String lastName, java.sql.Date doB,
                   String email, String address, String telNo,
                   String password, String allergies,
                   double punctuality, double moneyOwed, double attendance,
                   EmergencyContact emergencyContact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.doB = doB;
        this.email = email;
        this.address = address;
        this.telNo = telNo;
        this.password = password;
        this.allergies = allergies;
        this.punctuality = punctuality;
        this.moneyOwed = moneyOwed;
        this.attendance = attendance;
        this.emergencyContact = emergencyContact;
    }
    public Student(String firstName, String lastName, java.sql.Date doB,
                   String email, String address, String telNo,
                   String password, String allergies,
                   EmergencyContact emergencyContact){
        this.firstName = firstName;
        this.lastName = lastName;
        this.doB = doB;
        this.email = email;
        this.address = address;
        this.telNo = telNo;
        this.password = password;
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
        this.moneyOwed=0;
        this.attendance=0;
        this.punctuality=0;
    }
    public Student(String email, String password){
        this.email=email;
        this.password=password;
    }

    // Person interface implementation
    @Override
    public String getFirstName() { return firstName; }
    @Override
    public void setFirstName(String firstName) { this.firstName = firstName; }
    @Override
    public String getLastName() { return lastName; }
    @Override
    public void setLastName(String lastName) { this.lastName = lastName; }
    @Override
    public java.sql.Date getDoB() { return doB; }
    @Override
    public void setDoB(java.sql.Date doB) { this.doB = doB; }
    @Override
    public String getEmail() { return email; }
    @Override
    public void setEmail(String email) { this.email = email; }
    @Override
    public String getAddress() { return address; }
    @Override
    public void setAddress(String address) { this.address = address; }
    @Override
    public String getTelNo() { return telNo; }
    @Override
    public void setTelNo(String telNo) { this.telNo = telNo; }

    // Student specific getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }
    public double getPunctuality() { return punctuality; }
    public void setPunctuality(double punctuality) { this.punctuality = punctuality; }
    public double getMoneyOwed() { return moneyOwed; }
    public void setMoneyOwed(double moneyOwed) { this.moneyOwed = moneyOwed; }
    public double getAttendance() { return attendance; }
    public void setAttendance(double attendance) { this.attendance = attendance; }
    public EmergencyContact getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }


}
