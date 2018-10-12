package com.draper.web.to.v1;

import com.draper.entity.Student;

public class StudentGet {

    private int code;
    private String message;
    private int onlineId;
    private String studyType;
    private long startStudyTime;
    private String dailyLink;
    private String wish;
    private String coachSenior;
    private String knowFrom;
    private String name;
    private String qq;
    private String graduateSchool;

    public StudentGet(int code, String message, Student student){
        this.code = code;
        this.message = message;
        onlineId = student.getOnlineId();
        studyType = student.getStudyType();
        startStudyTime = student.getStartStudyTime();
        dailyLink = student.getDailyLink();
        wish = student.getWish();
        coachSenior = student.getCoachSenior();
        knowFrom = student.getKnowFrom();
        name = student.getName();
        qq = student.getQq();
        graduateSchool = student.getGraduateSchool();
    }

    public int getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(int onlineId) {
        this.onlineId = onlineId;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public long getStartStudyTime() {
        return startStudyTime;
    }

    public void setStartStudyTime(long startStudyTime) {
        this.startStudyTime = startStudyTime;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getCoachSenior() {
        return coachSenior;
    }

    public void setCoachSenior(String coachSenior) {
        this.coachSenior = coachSenior;
    }

    public String getKnowFrom() {
        return knowFrom;
    }

    public void setKnowFrom(String knowFrom) {
        this.knowFrom = knowFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
