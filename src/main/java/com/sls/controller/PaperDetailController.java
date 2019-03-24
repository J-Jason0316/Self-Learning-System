package com.sls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sls.service.PaperDetailService;
import com.sls.util.ReturnDataInit;

import com.sls.vo.Question;

@Controller
@RequestMapping("/paperDetail")
public class PaperDetailController {
	@Autowired
	private PaperDetailService paperDetailService ;
	@Autowired
	private	ReturnDataInit returnDataInit;
	
	/**
	 * 根据paperId获取PaperDetail(该试卷下的所有问题)
	 * @param paperId
	 * @return List
	 * */
	@RequestMapping(value = "/getPaperDetailByPaperId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getPaperDetailByPaperId(int paperId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();        
        
        List<Question> QuestionList = paperDetailService.getPaperDetailByPaperId(paperId);
        
        if (QuestionList.size() != 0) {
        	jsonObject.put("data", QuestionList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
}
