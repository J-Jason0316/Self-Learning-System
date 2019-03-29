package com.sls.dao;

import java.util.List;

import com.sls.vo.PaperDetail;

public interface PaperDetailDao {
	
    int insert(PaperDetail record);

    int insertSelective(PaperDetail record);
    
    List<PaperDetail> selectAllPaperDetail();
    
    List<PaperDetail> selectAllPaperDetailByPaperId(int paperId);
    
    int insertPaperDetailByBatch(List<PaperDetail> paperDetailList);
    //删除该试卷和其试卷详情
    int deletePaperDetailByPaperId(int paperId);
    
    int deletePaperDetailByQuestionId(int[] questionId);
}