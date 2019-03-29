package com.sls.dao;

import java.util.List;

import com.sls.vo.Paper;
import com.sls.vo.PaperDetail;

public interface PaperDao {
    int deleteByPrimaryKey(Integer paperId);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer paperId);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);
    /************************************************/
    
    int deleteByBatch(int[] paperId);
    
    List<Paper> selectByOtherCondition(Paper record);
    
    List<Paper> selectAllPaper();
    
    List<Paper> selectAllPaperAndDetail(int paperId);
    
    int insertPaperDetail(List<PaperDetail> paperDetailList);
    
    
}