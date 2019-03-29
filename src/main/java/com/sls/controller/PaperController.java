package com.sls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sls.service.PaperService;
import com.sls.util.ReturnDataInit;
import com.sls.vo.Paper;

@Controller
@RequestMapping("/paper")
public class PaperController {
	@Autowired
	private PaperService paperService;
	@Autowired
	private	ReturnDataInit returnDataInit;
	
	/**
	 * 多条件获取Paper
	 * @param paper
	 * @return JSONObject
	 * */
	@RequestMapping(value = "/getPaperByOtherCondition", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getPaperByOtherCondition(@RequestBody Paper paper) {
		
		JSONObject jsonObject = returnDataInit.initSetting();        
        
        List<Paper> paperList = paperService.getPaperByOtherCondition(paper);
        
        if (paperList.size() != 0) {
        	jsonObject.put("data", paperList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	
	/**
	 * 删除Paper
	 * @param paperId
	 * @return JSONObject
	 * */
	
	@RequestMapping(value = "/deletePaper", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject deletePaper (int paperId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();       
        
        int status = paperService.deletePaper(paperId);
        
        if (status!=1) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 批量删除paper
	 * @param paperId
	 * @return int
	 * */
	@RequestMapping(value = "/deletePaperByBatch", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deletePaper (@RequestBody int[] paperId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();       
        
        int status = paperService.deletePaper(paperId);
        
        if (status<=0) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 修改Paper
	 * @param paper
	 * @return JSONObject
	 * */
	@RequestMapping(value = "/updatePaper", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updatePaper(@RequestBody Paper paper){
		
		JSONObject jsonObject = returnDataInit.initSetting();       
        
        int status = paperService.updatePaper(paper);
        
        if (status!=1) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 添加Paper
	 * @param paper
	 * @return JSONObject
	 * */
	@RequestMapping(value = "/insertPaper", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject insertPaper(@RequestBody Paper paper){

		JSONObject jsonObject = returnDataInit.initSetting();       
        
        int status = paperService.insertPaper(paper);
        
        if (status!=1) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 查询所有Paper
	 * @param 
	 * @return JSONObject
	 * */
	@RequestMapping(value = "/getAllPaper", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject selectAllPaper(){
		
		JSONObject jsonObject = returnDataInit.initSetting();        
        
        List<Paper> paperList = paperService.getAllPaper();
        
        if (paperList.size() != 0) {
        	jsonObject.put("data", paperList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;	
	}
	
	/**
	 * 查询对应paper及其question
	 * @param 
	 * @return list
	 * */
	@RequestMapping(value = "/getAllPaperAndQuestion", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllPaperAndQuestion(int paperId){
		
		JSONObject jsonObject = returnDataInit.initSetting();        
        
        List<Paper> paperList = paperService.getAllPaperAndDetail(paperId);
        
        if (paperList.size() != 0) {
        	jsonObject.put("data", paperList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;	
	}
	
	
}
