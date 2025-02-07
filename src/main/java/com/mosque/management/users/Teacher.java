package com.mosque.management.users;

import java.util.Date;

public class Teacher implements Person{
    private String firstName;
    private String lastName;
    private java.sql.Date doB;
    private String email;
    private String address;
    private String telNo;
    private String username;
    private String allergies;
    private String password;
    private String cv;
    private double salary;
    private int hours;
    public Teacher(String firstName, String lastName, java.sql.Date doB,
                   String email, String address, String telNo,
                   String allergies, String password, String cv,
                   double salary, int hours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.doB = doB;
        this.email = email;
        this.address = address;
        this.telNo = telNo;
        this.allergies = allergies;
        this.password = password;
        this.cv = cv;
        this.salary = salary;
        this.hours = hours;
    }
    public Teacher(String email, String password){
        this.email=email;
        this.password=password;
    }
    public Teacher(String fir, String lastName, java.sql.Date doB, String email,
                   String address, String telNo, String allergies, String password,
                   double salary, String CV, int hours){
        this.firstName = fir;
        this.lastName = lastName;
        this.doB = doB;
        this.email = email;
        this.address = address;
        this.telNo = telNo;
        this.password = password;
        this.cv = CV;
        this.salary = salary;
        this.hours = hours;
        this.allergies=allergies;
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

    // Teacher specific getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getCv() { return cv; }
    public void setCv(String cv) { this.cv = cv; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public int getHours() { return hours; }
    public void setHours(int hours) { this.hours = hours; }
}
