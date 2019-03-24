package com.sls.service;

import java.util.List;

import com.sls.vo.Answer;

public interface AnswerService {
	
	/**
	 * 添加答卷
	 * @param answer
	 * @return int
	 * */
	int insertAnswer(Answer answer);
	
	/**
	 * 修改答卷
	 * @param answer
	 * @return int
	 * */
	int updateAnswer(Answer answer);
	
	/**
	 * 删除答卷
	 * @param answerId
	 * @return int
	 * */
	int deleteAnswer(int answerId);
	
	/**
	 * 根据答题人查询其所属答卷
	 * @param answerUserId
	 * @return List
	 * */
	List<Answer> getAnswerByAnswerUserId(String answerUserId);
	
	/**
	 * 根据answerId查询答卷
	 * @param answerId
	 * @return List
	 * */
	Answer getAnswerByAnswerId(int answerId);
}
