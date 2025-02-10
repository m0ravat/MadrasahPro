package com.mosque.management.education;

public class Exam {
    private int examID;
    private double total;
    private String type;
    private int weekTaken;
    private String subjectName;
    private String teacher;

    public Exam(int examID, double total, String type, int weekTaken, String subjectName, String teacher) {
        this.examID = examID;
        this.total = total;
        this.type = type;
        this.weekTaken = weekTaken;
        this.subjectName = subjectName;
        this.teacher = teacher;
    }

    // Getters and Setters
    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeekTaken() {
        return weekTaken;
    }

    public void setWeekTaken(int weekTaken) {
        this.weekTaken = weekTaken;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return
                "Exam ID: " + this.examID + "\n" +
                        "Total: " + this.total + "\n" +
                        "Type: " + this.type + "\n" +
                        "Week taken; " + this.weekTaken + "\n" +
                        "Subject: " + this.subjectName + "\n" +
                        "Teacher: " + this.teacher;
    }
}
