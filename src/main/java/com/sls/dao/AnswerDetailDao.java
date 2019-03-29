package com.sls.dao;

import com.sls.vo.AnswerDetail;

public interface AnswerDetailDao {
    int insert(AnswerDetail record);

    int insertSelective(AnswerDetail record);
    
    int deleteAllAnswerDetailByAnswerId(int answerId);
}