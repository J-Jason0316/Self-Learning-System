package com.sls.vo;

public class AnswerDetail {
    private Integer answerId;

    private Integer questionId;

    private String answer;

    @Override
	public String toString() {
		return "AnswerDetail [answerId=" + answerId + ", questionId=" + questionId + ", answer=" + answer + "]";
	}

	public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}