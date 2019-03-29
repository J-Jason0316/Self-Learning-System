package com.sls.service;

import java.util.List;

import com.sls.vo.Question;

public interface QuestionService {
	
	/******************************************************************
	 * 							题目查询                                                       *
	 * ****************************************************************/
	/**
	 * 获取所有question
	 * @param 
	 * @return list
	 * */
	List<Question> getAllQuestion();
	
	/**
	 * 根据主键获取question
	 * @param questionId
	 * @return Question
	 * */
	Question selectByPrimaryKey(int questionId);
	
	/**
	 * 根据出题人获取question
	 * @param questionUserId
	 * @return List
	 * */
	List<Question> getQuestionByQuestionUserId(String questionUserId);
	
	/**
	 * 根据课程获取question
	 * @param courseId
	 * @return List
	 * */
	List<Question> getQuestionByCourseId(int courseId);
		
	/**
	 * 根据题目类型获取question
	 * @param questionType
	 * @return List
	 * */
	List<Question> getQuestionByQuestionType(int questionType);
	
	/**
	 * 根据题目难度获取question
	 * @param questionHard
	 * @return List
	 * */
	List<Question> getQuestionByQuestionHard(int questionHard);
	
	/**
	 * 多条件获取question
	 * @param question
	 * @return List
	 * */
	 List<Question>	getQuestionByOtherCondition(Question question);
	 
	 /**
	  * 多条件获取question(questionType判断条件为<=)
	  * @param question Question
	  * @return List
	  * */
	 List<Question>	getQuestionByOtherCondition2(Question question);
	 
	 /**
	  * 根据paperId获取生育未选择的question
	  * @param paperId
	  * @return List
	  * */
	 List<Question> getAllUnchoiceQuestion(int paperId);
	 
	 /******************************************************************
	  * 							题目添加                                                 *
	  *****************************************************************/
	 /**
	  * 添加question
	  * @param question
	  * @return int
	  * */
	 int insertQuestion(Question question);
	 
	 /**
	  * 更新question
	  * @param question
	  * @return int
	  * */
	 int updateQuestion(Question question);
	 
	 /**
	  * 根据questionId删除question
	  * @param questionId
	  * @return int
	  * */
	 int deleteQuestion(int questionId);
	 
	 
	 /**
	  * 批量删除question
	  * @param questionId
	  * @return int
	  * */
	 int deleteQuestionByBatch(int[] questionId);
}
