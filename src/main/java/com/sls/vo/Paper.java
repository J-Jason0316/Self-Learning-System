package com.sls.vo;

public class Paper {
    private Integer paperId;

    private String paperUserId;

    private Integer courseId;

    private String paperTime;

    private String paperName;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperUserId() {
        return paperUserId;
    }

    public void setPaperUserId(String paperUserId) {
        this.paperUserId = paperUserId == null ? null : paperUserId.trim();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getPaperTime() {
        return paperTime;
    }

    public void setPaperTime(String paperTime) {
        this.paperTime = paperTime == null ? null : paperTime.trim();
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }
}