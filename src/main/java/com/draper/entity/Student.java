package com.draper.entity;

public class Student {

    private long createAt;
    private long updateAt;
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

    public Student() {
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

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }
}
