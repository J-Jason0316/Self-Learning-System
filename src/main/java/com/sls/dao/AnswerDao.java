package com.sls.dao;

import java.util.List;

import com.sls.vo.Answer;
import com.sls.vo.AnswerDetail;

public interface AnswerDao {
    int deleteByPrimaryKey(Integer answerId);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer answerId);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
    
    /****************************************/
    List<Answer> selectByAnswerUserId(String answerUserId);
    
    int insertAnswerDetail(List<AnswerDetail> answerDetailList);
}