package com.sls.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sls.service.AnswerService;
import com.sls.util.ReturnDataInit;
import com.sls.vo.Answer;


@Controller
@RequestMapping("answer")
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	@Autowired
	private ReturnDataInit returnDataInit;
	
	/**
	 * 添加答卷
	 * @param Answer
	 * @return jsonObject
	 * */
	@RequestMapping(value = "/insertAnswer", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject insertAnswer(@RequestBody Answer answer) {
		
		JSONObject jsonObject = returnDataInit.initSetting();
		
		
		Map<String,Integer> result = answerService.insertAnswer(answer);
 
        if (result.get("insertScorestatus")!=1&&result.get("insertAnswerDetailStatus")!=1) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		} else {
			jsonObject.put("score",result.get("score"));
		}
        return jsonObject;		
	}
	
	/**
	 * 修改答卷
	 * @param Answer
	 * @return jsonObject
	 * */
	@RequestMapping(value = "/updateAnswer", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updateAnswer(@RequestBody Answer answer) {
		
		JSONObject jsonObject = returnDataInit.initSetting();
		
		int status = answerService.updateAnswer(answer);
 
        if (status!=1) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;		
	}
	
	/**
	 * 删除答卷
	 * @param answerId
	 * @return jsonObject
	 * */
	@RequestMapping(value = "/deleteAnswer", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject deleteAnswer(int answerId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();
		
		int status = answerService.deleteAnswer(answerId);
 
        if (status!=1) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;		
	}
	
	/**
	 * 根据答题人查询其所属答卷
	 * @param answerUserId
	 * @return jsonObject
	 * */
	@RequestMapping(value = "/getAnswerByAnswerUserId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAnswerByAnswerUserId(String answerUserId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();        
        
        List<Answer> answerList = answerService.getAnswerByAnswerUserId(answerUserId);
        
        if (answerList.size() != 0) {
        	jsonObject.put("data", answerList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 根据answerId查询答卷
	 * @param answerId
	 * @return jsonObject
	 * */
	@RequestMapping(value = "/getAnswerByAnswerId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAnswerByAnswerId(int answerId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();        
        
        Answer answer = answerService.getAnswerByAnswerId(answerId);
        
        if (answer != null) {
        	jsonObject.put("data", answer);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
}
