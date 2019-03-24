package com.sls.service;

import java.util.List;

import com.sls.vo.Question;

public interface PaperDetailService {
	
	/**
	 * 根据paperId获取PaperDetail(该试卷下的所有问题)
	 * @param paperId
	 * @return List
	 * */
	List<Question> getPaperDetailByPaperId(int paperId);
}
