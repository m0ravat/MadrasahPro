package com.mosque.management.education;

public class Subject {
    private String subjectName;
    private String desc;
    private String overview;
    private String outcome;
    private int duration;
    private String startDate;
    private String grade;
    private Course course;
    public Subject(String subjectName, String desc, String overview, String outcome,
                   int duration, String startDate, String grade, Course course) {
        this.subjectName = subjectName;
        this.desc = desc;
        this.overview = overview;
        this.outcome = outcome;
        this.duration = duration;
        this.startDate = startDate;
        this.grade = grade;
        this.course = course;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
