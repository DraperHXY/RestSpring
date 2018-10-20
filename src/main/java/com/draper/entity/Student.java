package com.draper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {

    @JsonIgnore
    private long createAt;

    @JsonIgnore
    private long updateAt;

//    @Length(min = 1, max = 8, message = "{student.onlineId.size}")
    @NotNull(message = "student.onlineId.notnull")
    private int onlineId;

    @NotBlank(message = "student.studentType.notnull")
    private String studyType;

    @NotNull(message = "student.startStudyTime.notnull")
    private long startStudyTime;

    @NotBlank(message = "student.dailyLink.notnull")
    private String dailyLink;

    @NotBlank(message = "student.wish.notnull")
    private String wish;

    @NotBlank(message = "student.coachSenior.notnull")
    private String coachSenior;

    @NotBlank(message = "student.knowFrom.notnull")
    private String knowFrom;

    @Size(min = 1, max = 20, message = "student.name.size")
    private String name;

    @Size(min = 4, max = 15, message = "student.qq.size")
    private String qq;

    @NotBlank(message = "student.graduate.notnull")
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

    public enum KEY {
        STUDY_TYPE, DAILY_LINK, COACH_SENIOR
    }
}
