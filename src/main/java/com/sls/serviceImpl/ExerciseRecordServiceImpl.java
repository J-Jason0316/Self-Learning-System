package com.sls.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.dao.ExerciseRecordDao;
import com.sls.service.ExerciseRecordService;
import com.sls.vo.ExerciseRecord;

@Service
public class ExerciseRecordServiceImpl implements ExerciseRecordService{
	@Autowired
	private ExerciseRecordDao exerciseRecordDao;

	/**
	 * 添加刷题记录
	 * @param exerciseRecord
	 * @return int
	 * */
	public int insertExerciseRecordByBatch(List<ExerciseRecord> exerciseRecord) {
		return exerciseRecordDao.insertExerciseRecordByBatch(exerciseRecord);
	}
	
	/**
	 * 根据recordUserId获取刷题记录
	 * @param recordId
	 * @return list
	 * */
	public List<ExerciseRecord> getExerciseRecordByRecordUserId(String recordUserId) {
		return exerciseRecordDao.selectByRecordUserId(recordUserId);
	}
	
	/**
	 * 根据recordId获取刷题记录
	 * @param recordId
	 * @return list
	 * */
	public ExerciseRecord getExerciseRecordByRecordId(int recordId) {
		return exerciseRecordDao.selectByPrimaryKey(recordId);
	} 
}
