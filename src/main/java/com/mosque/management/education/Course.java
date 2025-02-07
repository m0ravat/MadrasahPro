package com.mosque.management.education;

public class Course {
    private String courseName;
    private String shortDesc;
    private String longDesc;
    private int duration;
    private double price;
    public Course(String courseName, String shortDesc, String longDesc, int duration,
                  double price) {
        this.courseName = courseName;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.duration = duration;
        this.price = price;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return "Course Name : " + courseName + "\n" + " Short Description : " +
                shortDesc + "\n" + " LongDesc : " + longDesc +
                "\n" + " Duration : " + duration + "\n" + "Price : " + price;
    }
}
