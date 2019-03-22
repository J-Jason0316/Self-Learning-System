package com.sls.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.dao.QuestionDao;
import com.sls.service.QuestionService;
import com.sls.vo.Question;

@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private QuestionDao questionDao;
	
	
	/**
	 * 获取所有question
	 * @param 
	 * @return list
	 * */
	public List<Question> getAllQuestion() {
		return  questionDao.selectAllQuestion();
	}
	
	/**
	 * 根据主键获取question
	 * @param questionId
	 * @return Question
	 * */
	public Question	selectByPrimaryKey(int questionId) {
		return questionDao.selectByPrimaryKey(questionId);
	}
	
	/**
	 * 根据出题人获取question
	 * @param questionUserId
	 * @return List
	 * */
	public List<Question> getQuestionByQuestionUserId(String questionUserId) {
		return  questionDao.selectByQuestionUserId(questionUserId);
	}
	
	/**
	 * 根据课程获取question
	 * @param courseId
	 * @return List
	 * */
	public List<Question> getQuestionByCourseId(int courseId) {
		return  questionDao.selectByQuestionCourseId(courseId);
	}
	
	/**
	 * 根据题目类型获取question
	 * @param questionType
	 * @return List
	 * */
	public List<Question> getQuestionByQuestionType(int questionType) {
		return  questionDao.selectByQuestionType(questionType);
	}
	
	/**
	 * 根据题目难度获取question
	 * @param questionHard
	 * @return List
	 * */
	public List<Question> getQuestionByQuestionHard(int questionHard) {
		return  questionDao.selectByQuestionHard(questionHard);
	}
	
	/**
	 * 多条件获取question
	 * @param question
	 * @return List
	 * */
	public List<Question> getQuestionByOtherCondition(Question question) {
		return  questionDao.selectByOtherCondition(question);
	}
	
	/**
	 * 添加question
	 * @param question
	 * @return int
	 * */
	public int insertQuestion(Question question) {
		return  questionDao.insertSelective(question);
	}
	
	/**
	 * 更新question
	 * @param question
	 * @return int
	 * */
	public int updateQuestion(Question question) {
		return  questionDao.updateByPrimaryKeySelective(question);
	}
	
	
	public int deleteQuestion(int questionId) {
		return  questionDao.deleteByPrimaryKey(questionId);
	}
}
