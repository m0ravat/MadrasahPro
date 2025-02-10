package com.mosque.management.users;

import com.mosque.management.education.Course;

import java.sql.Date;
import java.util.Objects;

public class Student implements Person{
    private String firstName = "Null";
    private String lastName = "Null";
    private java.sql.Date doB = new java.sql.Date(new java.util.Date().getTime());
    private String email = "Null";
    private String address = "Null";
    private String telNo = "Null";
    private String username = "Null";
    private String password = "Null";
    private String allergies = "Null";
    private double punctuality;
    private double moneyOwed;
    private double attendance=0.00;
    private EmergencyContact emergencyContact;
    private Course course;

    private int yearJoined;
    private int monthJoined;
    private String courseName = "Not enrolled";
    private String grade;
    private String status;

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
    public Student(String firstName, String lastName, java.sql.Date doB,
                   String email, String address, String telNo, String password,
                   String allergies, String courseName, int yearJoined, int monthJoined,
                   String grade, String status, double moneyOwed, double punctuality, double attendance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.doB = doB;
        this.email = email;
        this.address = address;
        this.telNo = telNo;
        this.password = password;
        this.allergies = allergies;
        this.courseName = courseName;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.grade = grade;
        this.status = status;
        this.moneyOwed=moneyOwed;
        this.punctuality=punctuality;
        this.attendance=attendance;
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
    public Date getDoB() { return doB; }
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
    public void setCourse(Course course){
        this.course=course;
    }
    public int getYearJoined(){
        return this.yearJoined;
    }
    public String getCourse(){
        return this.courseName;
    }
    public String toString(){
        String courseDetails = "";
        if (!Objects.equals(this.courseName, "Not enrolled")){
            courseDetails = "Course enrolled in : " + this.courseName + "\n" +
                    "Date joined : " + this.monthJoined + "/" + this.yearJoined + "\n" +
                    "Grade : " + this.grade + "\n" +
                    "Status of grade : " + this.status ;
        }
        return "Name : " + this.firstName + " " + this.lastName + "\n" +
                "Email : " + this.email + "\n" +
                "Telephone number : " + this.telNo + "\n" +
                "Address : " + this.address + "\n" +
                "Date of birth : " + this.doB + "\n" +
                "Allergies : " + this.allergies + "\n" +
                "Punctuality : " + this.punctuality + "\n" +
                "Attendance : " + this.attendance + "\n" +
                "Money owed : " + this.moneyOwed + "\n" + courseDetails;
    }


}
