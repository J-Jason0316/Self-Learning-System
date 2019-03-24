package com.sls.service;

import java.util.List;

import com.sls.vo.Paper;


public interface PaperService {
	/******************************************************************
	 * 							试卷查询                                                       *
	 * ****************************************************************/
	/**
	 * 获取所有Paper
	 * @param paper
	 * @return list
	 * */
	List<Paper> getPaperByOtherCondition(Paper paper);
	
	/**
	 * 删除paper
	 * @param paperId
	 * @return int
	 * */
	
	 int deletePaper(int paperId);
	 
	 /**
	 * 修改paper
	 * @param paper
	 * @return int
	 * */
	 int updatePaper(Paper paper);
	 
	 /**
	 * 添加paper
	 * @param paper
	 * @return int
	 * */
	 int insertPaper(Paper paper);
	 
	 /**
	 * 查询所有paper
	 * @param 
	 * @return list
	 * */
	 List<Paper> getAllPaper();
	 
	 /**
	 * 查询所有paper+question
	 * @param 
	 * @return list
	 * */
	 List<Paper> getAllPaperAndDetail(int paperId);
	 

}
