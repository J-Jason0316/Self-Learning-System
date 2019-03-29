package com.sls.service;

import java.util.List;

import com.sls.vo.PaperDetail;
import com.sls.vo.Question;

public interface PaperDetailService {
	
	/**
	 * 根据paperId获取PaperDetail(该试卷下的所有问题)
	 * @param paperId
	 * @return List
	 * */
	List<Question> getPaperDetailByPaperId(int paperId);
	
	/**
	 * 批量插入PaperDetail(该试卷下的所有问题)
	 * @param paperDetailList
	 * @return int
	 * */
	int insertPaperDetailByBatch(List<PaperDetail> paperDetailList);
	/**
	 * 删除试卷及其detail
	 * @param paperId
	 * @return int
	 * */
	int deletePaperDetailByPaperId(int paperId);
	
	/**
	 * 删除试卷及其部分detail
	 * @param int[] questionId
	 * @return int
	 * */
   int deletePaperDetailByQuestionId(int[] questionId);
}
