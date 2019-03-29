package com.sls.vo;

import java.util.List;

public class Paper {
    private Integer paperId;

    private String paperUserId;

    private Integer courseId;

    private String paperTime;

    private String paperName;
    
    private String courseName;
    
    private String paperUserName;
    
    private List<PaperDetail> paperDetail;
    
    private List<Question> question;

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

	public List<PaperDetail> getPaperDetail() {
		return paperDetail;
	}

	public void setPaperDetail(List<PaperDetail> paperDetail) {
		this.paperDetail = paperDetail;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getPaperUserName() {
		return paperUserName;
	}

	public void setPaperUserName(String paperUserName) {
		this.paperUserName = paperUserName;
	}
}