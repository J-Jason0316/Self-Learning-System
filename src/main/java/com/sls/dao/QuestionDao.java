package com.sls.dao;

import java.util.List;

import com.sls.vo.Question;

public interface QuestionDao {
    int deleteByPrimaryKey(Integer questionId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
    
    /*************************************/
    List<Question> selectAllQuestion();
    
    List<Question> selectByQuestionUserId(String questionUserId);
    
    List<Question> selectByQuestionCourseId(int courseId);
    
    List<Question> selectByQuestionType(int questionType);
    
    List<Question> selectByQuestionHard(int questionHard);
    //多条件查询
    List<Question> selectByOtherCondition(Question record);
}