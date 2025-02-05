package com.mosque.management.users;

import com.mosque.management.education.Course;
import java.util.ArrayList;
import java.util.List;
import com.mosque.management.users.EmergencyContact;

import java.util.Scanner;

public class Student implements Person{
    private String firstName;
    private String lastName;
    private String doB;
    private String email;
    private String address;
    private int telNo;
    private String username;
    private String password;
    private String allergies;
    private double punctuality;
    private double moneyOwed;
    private double attendance;
    private List<Course> courses;
    private List<Teacher> teachers;
    private List<EmergencyContact> emergencyContacts;
    public Student(String firstName, String lastName, String doB,
                   String email, String address, int telNo,
                   String username, String password, String allergies,
                   double punctuality, double moneyOwed, double attendance,
                   List<Course> courses, List<Teacher> teachers,
                   List<EmergencyContact> emergencyContacts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.doB = doB;
        this.email = email;
        this.address = address;
        this.telNo = telNo;
        this.username = username;
        this.password = password;
        this.allergies = allergies;
        this.punctuality = punctuality;
        this.moneyOwed = moneyOwed;
        this.attendance = attendance;
        this.courses = courses;
        this.teachers = teachers;
        this.emergencyContacts = emergencyContacts;
    }
    public Student(String firstName, String lastName, String doB,
                   String email, String address, int telNo,
                   String username, String password, String allergies,
                   List<EmergencyContact> emergencyContacts){
        this.firstName = firstName;
        this.lastName = lastName;
        this.doB = doB;
        this.email = email;
        this.address = address;
        this.telNo = telNo;
        this.username = username;
        this.password = password;
        this.allergies = allergies;
        this.emergencyContacts = emergencyContacts;
        this.moneyOwed=0;
        this.attendance=0;
        this.courses=new ArrayList<Course>();
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
    public String getDoB() { return doB; }
    @Override
    public void setDoB(String doB) { this.doB = doB; }
    @Override
    public String getEmail() { return email; }
    @Override
    public void setEmail(String email) { this.email = email; }
    @Override
    public String getAddress() { return address; }
    @Override
    public void setAddress(String address) { this.address = address; }
    @Override
    public int getTelNo() { return telNo; }
    @Override
    public void setTelNo(int telNo) { this.telNo = telNo; }

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
    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
    public List<Teacher> getTeachers() { return teachers; }
    public void setTeachers(List<Teacher> teachers) { this.teachers = teachers; }
    public List<EmergencyContact> getEmergencyContacts() { return emergencyContacts; }
    public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }


}
