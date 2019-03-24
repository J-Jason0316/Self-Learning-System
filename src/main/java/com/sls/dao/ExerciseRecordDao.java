package com.sls.dao;

import java.util.List;

import com.sls.vo.ExerciseRecord;

public interface ExerciseRecordDao {
    int deleteByPrimaryKey(Integer recordId);

    int insert(ExerciseRecord record);

    int insertSelective(ExerciseRecord record);

    ExerciseRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(ExerciseRecord record);

    int updateByPrimaryKey(ExerciseRecord record);
    
   /* ***********************************/
    List<ExerciseRecord> selectByRecordUserId(String recordUserId);
}