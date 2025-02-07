package com.mosque.management.education;

public class Subject {
    private String subjectName;
    private String shortDesc;
    private String overview;
    private String outcome;
    private int duration;
    private String startYear;

    public Subject(String subjectName, String shortDesc, String overview, String outcome,
                   int duration, String startYear) {
        this.subjectName = subjectName;
        this.shortDesc = shortDesc;
        this.overview = overview;
        this.outcome = outcome;
        this.duration = duration;
        this.startYear = startYear;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getshortDesc() {
        return shortDesc;
    }

    public void setshortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
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

    public String getstartYear() {
        return startYear;
    }

    public void setStartDate(String startYear) {
        this.startYear = startYear;
    }
    public String toString(){
        return "Subject Name : " + subjectName + "\n" +
                " Subject Desc : " + shortDesc + "\n" +
                " Subject Overview : " + overview + "\n" + " Start Year : " +
                startYear + "\n" + "Outcome : " + outcome + "\n" + duration + " years";
    }

}
