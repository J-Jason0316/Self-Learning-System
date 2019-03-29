package com.sls.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sls.dao.PaperDao;
import com.sls.dao.PaperDetailDao;
import com.sls.service.PaperService;
import com.sls.vo.Paper;

@Service
public class PaperServiceImpl implements PaperService {
	
	@Autowired
	private PaperDao paperDao;
	@Autowired 
	private PaperDetailDao paperDetailDao;
	
	/**
	 * 获取所有Paper
	 * @param 
	 * @return list
	 * */
	public List<Paper> getPaperByOtherCondition(Paper paper){
		return paperDao.selectByOtherCondition(paper);
	};
	
	/**
	 * 根据paperId删除paper
	 * @param paperId
	 * @return int
	 * */	
	@Transactional
	public int deletePaper(int paperId){
		paperDetailDao.deletePaperDetailByPaperId(paperId);
		 return paperDao.deleteByPrimaryKey(paperId);
	 }
	
	/**
	 * 批量删除paper
	 * @param paperId
	 * @return int
	 * */
	public int deletePaper(int[] paperId){
		 return paperDao.deleteByBatch(paperId);
	 }

	/**
	 * 修改paper
	 * @param paper
	 * @return int
	 * */
	public int updatePaper(Paper paper){
		 return paperDao.updateByPrimaryKeySelective(paper);
	 }
	
	/**
	 * 添加paper
	 * @param paper
	 * @return int
	 * */
	public int insertPaper(Paper paper){
		//paperDao.insertPaperDetail(paper.getPaperDetail());
		return paperDao.insertSelective(paper);
		
	}
	
	/**
	 * 查询所有paper
	 * @param 
	 * @return list
	 * */
	public List<Paper> getAllPaper(){
		return paperDao.selectAllPaper();
	}
	
	/**
	 * 查询所有paper+question
	 * @param 
	 * @return list
	 * */
	public List<Paper> getAllPaperAndDetail(int paperId){
		return paperDao.selectAllPaperAndDetail(paperId);
	}
}
