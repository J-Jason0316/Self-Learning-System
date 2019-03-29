package com.sls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sls.service.ExerciseRecordService;
import com.sls.util.ReturnDataInit;
import com.sls.vo.ExerciseRecord;

@Controller
@RequestMapping("exerciseRecord")
public class ExerciseRecordController {

	@Autowired
	private ExerciseRecordService exerciseRecordService;
	@Autowired
	private ReturnDataInit returnDataInit;

	
	/**
	 * 添加刷题记录
	 * @param exerciseRecord
	 * @return JSONObject
	 * */
	@RequestMapping(value = "/insertExerciseRecordByBatch", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject insertExerciseRecordByBatch(@RequestBody List<ExerciseRecord> exerciseRecord) {
		
		JSONObject jsonObject = returnDataInit.initSetting();
		
		
		int status = exerciseRecordService.insertExerciseRecordByBatch(exerciseRecord);
 
        if (status<=0) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;		
	}
	
	/**
	 * 根据recordUserId获取刷题记录
	 * @param recordUserId
	 * @return list
	 * */	
	@RequestMapping(value = "/getExerciseRecordByRecordUserId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getExerciseRecordByRecordUserId(String recordUserId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();
				
		List<ExerciseRecord> exerciseRecordList = exerciseRecordService.getExerciseRecordByRecordUserId(recordUserId);
 
		if (exerciseRecordList.size() != 0) {
        	jsonObject.put("data", exerciseRecordList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;		
	}
	
	/**
	 * 根据recordId获取刷题记录
	 * @param recordId
	 * @return list
	 * */
	@RequestMapping(value = "/getExerciseRecordByRecordId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getExerciseRecordByRecordId(int recordId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();
				
		ExerciseRecord exerciseRecord = exerciseRecordService.getExerciseRecordByRecordId(recordId);
 
		if (exerciseRecord != null) {
        	jsonObject.put("data", exerciseRecord);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;		
	}
	
	
}
