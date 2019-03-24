package com.sls.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.dao.AnswerDao;
import com.sls.service.AnswerService;
import com.sls.vo.Answer;

@Service
public class AnswerServiceImpl implements AnswerService{
	@Autowired
	private AnswerDao answerDao;
	
	/**
	 * 添加答卷
	 * @param Answer
	 * @return int
	 * */
	public int insertAnswer(Answer answer) {
		answerDao.insertAnswerDetail(answer.getAnswerDetail());
		return answerDao.insertSelective(answer);
	}
	
	/**
	 * 修改答卷
	 * @param Answer
	 * @return int
	 * */
	public int updateAnswer(Answer answer) {
		return answerDao.updateByPrimaryKeySelective(answer);
	}
	
	/**
	 * 根据answerId删除答卷
	 * @param answerId
	 * @return int
	 * */
	public int deleteAnswer(int answerId) {
		return answerDao.deleteByPrimaryKey(answerId);
	}
	
	/**
	 * 根据答题人查询其所属答卷
	 * @param answerUserId
	 * @return List
	 * */
	public List<Answer> getAnswerByAnswerUserId(String answerUserId) {
		return answerDao.selectByAnswerUserId(answerUserId);
	}
	
	/**
	 * 根据answerId查询答卷
	 * @param answerId
	 * @return List
	 * */
	public Answer getAnswerByAnswerId(int answerId) {
		return answerDao.selectByPrimaryKey(answerId);
	}
}
