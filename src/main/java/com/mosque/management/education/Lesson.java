package com.mosque.management.education;
import com.mosque.management.users.Teacher;

public class Lesson {
    private String lessonName;
    private int weekNo;
    private int duration;
    private String timeStart;
    private String subject;
    private String Teacher;
    public Lesson(String lessonName, int weekNo,
                  int duration, String timeStart, String subject, String Teacher) {
        this.lessonName = lessonName;
        this.weekNo = weekNo;
        this.duration = duration;
        this.timeStart = timeStart;
        this.subject = subject;
        this.Teacher = Teacher;

    }
    public String getTeacher() {
        return Teacher;
    }
    public void setTeacher(String Teacher) {
        this.Teacher = Teacher;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }
    @Override
    public String toString(){
        return "Lesson name: " + this.lessonName + "\n" +
                "Week: " + this.weekNo + "\n" +
                "Duration: " + this.duration + "\n" +
                "Starts at: " + this.timeStart + "\n" +
                "Led by: " + this.Teacher + "\n" +
                "For subject: " + this.subject;
    }
}
