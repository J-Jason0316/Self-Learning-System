package com.sls.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.dao.AnswerDao;
import com.sls.dao.AnswerDetailDao;
import com.sls.service.AnswerService;
import com.sls.vo.Answer;
import com.sls.vo.AnswerDetail;

@Service
public class AnswerServiceImpl implements AnswerService{
	@Autowired
	private AnswerDao answerDao;
	@Autowired
	private AnswerDetailDao answerDetailDao;

	
	
	/**
	 * 添加答卷+计算成绩
	 * @param Answer
	 * @return int
	 * */
	public Map<String,Integer> insertAnswer(Answer answer) {
		
		
		int answerId = Integer.parseInt(answerDao.isHaveAnswer(answer)==null?"0":answerDao.isHaveAnswer(answer));
		int Score = 0;
		int insertScore = 0;
		int insertAnswerDetail = 0;
		
		if(answerId == 0) {
			int test = answerDao.insertSelective(answer);
			System.out.println(test);
			int newAnswerId = answer.getAnswerId();
			
			System.out.println(answer.getAnswerId());
			
			List<AnswerDetail> list = answer.getAnswerDetail();
			System.out.println(list.get(0));
			for(AnswerDetail L :list){
				L.setAnswerId(newAnswerId);
			}
			insertAnswerDetail = answerDao.insertAnswerDetail(list);	
			System.out.println(list.get(0));
			//计算成绩
			double total = list.size();
			int correct = answerDao.getScore(newAnswerId);
			
			System.out.println("correct"+correct);
		
			Score = (int)((correct/total)*100);
			//插入成绩
			answer.setAnswerScore(Integer.toString(Score));
			answer.setAnswerId(newAnswerId);
			
			insertScore = answerDao.updateByPrimaryKeySelective(answer);
			
			
					
		} else {
			
			System.out.println(answerId);
			//删除以前的做题数据
			answerDetailDao.deleteAllAnswerDetailByAnswerId(answerId);
			
			answer.setAnswerId(answerId);

			List<AnswerDetail> list = answer.getAnswerDetail();
			System.out.println(list.get(0));
			for(AnswerDetail L :list){
				L.setAnswerId(answerId);
			}
			insertAnswerDetail = answerDao.insertAnswerDetail(list);
			System.out.println(list.get(0));
			//计算成绩
			double total = list.size();
			System.out.println("answerId"+answerId);	
			int correct = answerDao.getScore(answerId);
			
			System.out.println("correct"+correct);	
			
		    Score = (int)((correct/total)*100);
		    //插入成绩
			answer.setAnswerScore(Integer.toString(Score));
			insertScore = answerDao.updateByPrimaryKeySelective(answer);
			
		}

		Map<String,Integer> statusAndScore = new HashMap<String,Integer>();
		
		statusAndScore.put("insertScorestatus", insertScore);
		statusAndScore.put("insertAnswerDetailStatus", insertAnswerDetail);
		statusAndScore.put("score", Score);
		return statusAndScore;
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
