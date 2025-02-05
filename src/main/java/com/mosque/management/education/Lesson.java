package com.mosque.management.education;
import com.mosque.management.users.Teacher;

public class Lesson {
    private String lessonName;
    private int weekNo;
    private String date;
    private int duration;
    private String timeStart;
    private Subject subject;
    private Teacher Teacher;
    public Lesson(String lessonName, int weekNo, String date,
                  int duration, String timeStart, Subject subject, Teacher Teacher) {
        this.lessonName = lessonName;
        this.weekNo = weekNo;
        this.date = date;
        this.duration = duration;
        this.timeStart = timeStart;
        this.subject = subject;
        this.Teacher = Teacher;

    }
    public Teacher getTeacher() {
        return Teacher;
    }
    public void setTeacher(Teacher Teacher) {
        this.Teacher = Teacher;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
}
