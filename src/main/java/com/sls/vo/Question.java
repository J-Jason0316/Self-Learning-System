package com.sls.vo;

public class Question {
    private Integer questionId;

    private String questionUserId;
    
    private String questionUserName;

    private Integer courseId;
    
    private String courseName;

    private String questionInfo;

    private String questionChoiceA;

    private String questionChoiceB;

    private String questionChoiceC;

    private String questionChoiceD;

    private String questionAnswer;

    private Integer questionType;

    private Integer questionHard;
    
  

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionUserId() {
        return questionUserId;
    }

    public void setQuestionUserId(String questionUserId) {
        this.questionUserId = questionUserId == null ? null : questionUserId.trim();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getQuestionInfo() {
        return questionInfo;
    }

    public void setQuestionInfo(String questionInfo) {
        this.questionInfo = questionInfo == null ? null : questionInfo.trim();
    }

    public String getQuestionChoiceA() {
        return questionChoiceA;
    }

    public void setQuestionChoiceA(String questionChoiceA) {
        this.questionChoiceA = questionChoiceA == null ? null : questionChoiceA.trim();
    }

    public String getQuestionChoiceB() {
        return questionChoiceB;
    }

    public void setQuestionChoiceB(String questionChoiceB) {
        this.questionChoiceB = questionChoiceB == null ? null : questionChoiceB.trim();
    }

    public String getQuestionChoiceC() {
        return questionChoiceC;
    }

    public void setQuestionChoiceC(String questionChoiceC) {
        this.questionChoiceC = questionChoiceC == null ? null : questionChoiceC.trim();
    }

    public String getQuestionChoiceD() {
        return questionChoiceD;
    }

    public void setQuestionChoiceD(String questionChoiceD) {
        this.questionChoiceD = questionChoiceD == null ? null : questionChoiceD.trim();
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer == null ? null : questionAnswer.trim();
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionHard() {
        return questionHard;
    }

    public void setQuestionHard(Integer questionHard) {
        this.questionHard = questionHard;
    }

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionUserId=" + questionUserId + ", courseId=" + courseId
				+ ", questionInfo=" + questionInfo + ", questionChoiceA=" + questionChoiceA + ", questionChoiceB="
				+ questionChoiceB + ", questionChoiceC=" + questionChoiceC + ", questionChoiceD=" + questionChoiceD
				+ ", questionAnswer=" + questionAnswer + ", questionType=" + questionType + ", questionHard="
				+ questionHard + "]";
	}

	public String getQuestionUserName() {
		return questionUserName;
	}

	public void setQuestionUserName(String questionUserName) {
		this.questionUserName = questionUserName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
    
    
    
    
}