package com.sls.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.dao.PaperDetailDao;
import com.sls.dao.QuestionDao;
import com.sls.service.PaperDetailService;
import com.sls.vo.PaperDetail;
import com.sls.vo.Question;

@Service
public class PaperDetailServiceImpl implements PaperDetailService{
	@Autowired
	private PaperDetailDao paperDetailDao;
	@Autowired
	private QuestionDao questionDao;

	/**
	 * 根据paperId获取PaperDetail(该试卷下的所有问题)
	 * @param paperId
	 * @return List
	 * */
	public List<Question> getPaperDetailByPaperId(int paperId) {
		
		List<PaperDetail> paperDetail = paperDetailDao.selectAllPaperDetailByPaperId(paperId);
		List<Question> questionList = new ArrayList<Question>();
		
		for(PaperDetail pd : paperDetail){
			int questionId = pd.getQuestionId();
			Question question = questionDao.selectByPrimaryKey(questionId);
			questionList.add(question);
		}
		return questionList;	
	}
	
	/**
	 * 批量插入PaperDetail(该试卷下的所有问题)
	 * @param paperDetailList
	 * @return int
	 * */
	public int insertPaperDetailByBatch(List<PaperDetail> paperDetailList) {	
		return paperDetailDao.insertPaperDetailByBatch(paperDetailList);
	}
	
	/**
	 * 删除试卷及其detail
	 * @param paperId
	 * @return int
	 * */
	public int deletePaperDetailByPaperId(int paperId) {	
		return paperDetailDao.deletePaperDetailByPaperId(paperId);
	}
	
	/**
	 * 删除试卷及其部分detail
	 * @param int[] questionId
	 * @return int
	 * */
	
	public int deletePaperDetailByQuestionId(int[] questionId) {
		return paperDetailDao.deletePaperDetailByQuestionId(questionId);
	}
}
