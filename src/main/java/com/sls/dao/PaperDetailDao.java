package com.sls.dao;

import java.util.List;

import com.sls.vo.PaperDetail;

public interface PaperDetailDao {
	
    int insert(PaperDetail record);

    int insertSelective(PaperDetail record);
    
    List<PaperDetail> selectAllPaperDetail();
}