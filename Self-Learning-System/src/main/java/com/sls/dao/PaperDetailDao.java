package com.sls.dao;

import com.sls.vo.PaperDetail;

public interface PaperDetailDao {
    int insert(PaperDetail record);

    int insertSelective(PaperDetail record);
}