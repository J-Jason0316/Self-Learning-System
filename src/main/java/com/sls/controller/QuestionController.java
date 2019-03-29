package com.sls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sls.service.QuestionService;
import com.sls.util.ReturnDataInit;
import com.sls.vo.Question;

@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private	ReturnDataInit returnDataInit;
	
	
	/**
	 * 获取所有question
	 * @param 
	 * @return list
	 * */
	@RequestMapping(value = "/getAllQuestion", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllQuestion() {
		
		JSONObject jsonObject = returnDataInit.initSetting();
   
		List<Question> questionList = questionService.getAllQuestion();
        
		if (questionList.size() != 0) {
        	jsonObject.put("data", questionList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 根据主键获取question
	 * @param questionId int
	 * @return Question
	 * */
	@RequestMapping(value = "/getQuestionByQuestionId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getQuestionByQuestionId(int questionId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();
   
        Question question = questionService.selectByPrimaryKey(questionId);
        
        if (question != null) {
        	jsonObject.put("data", question);
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	
	/**
	 * 根据出题人获取question
	 * @param questionUserId String
	 * @return List
	 * */
	@RequestMapping(value = "/getQuestionByQuestionUserId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getQuestionByQuestionUserId(String questionUserId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();       
        
        List<Question> questionList = questionService.getQuestionByQuestionUserId(questionUserId);
        
        if (questionList.size() != 0) {
        	jsonObject.put("data", questionList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 根据课程获取question
	 * @param courseId int
	 * @return List
	 * */
	@RequestMapping(value = "/getQuestionByCourseId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getQuestionByCourseId(int courseId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();      
        
        List<Question> questionList = questionService.getQuestionByCourseId(courseId);
        
        if (questionList.size() != 0) {
        	jsonObject.put("data", questionList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 根据题目类型获取question
	 * @param questionType int
	 * @return List
	 * */
	@RequestMapping(value = "/getQuestionByQuestionType", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getQuestionByQuestionType(int questionType) {
		
		JSONObject jsonObject = returnDataInit.initSetting();       
        
        List<Question> questionList = questionService.getQuestionByQuestionType(questionType);
        
        if (questionList.size() != 0) {
        	jsonObject.put("data", questionList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 根据题目难度获取question
	 * @param questionHard int
	 * @return List
	 * */
	@RequestMapping(value = "/getQuestionByQuestionHard", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getQuestionByQuestionHard(int questionHard) {
		
		JSONObject jsonObject = returnDataInit.initSetting();        
        
        List<Question> questionList = questionService.getQuestionByQuestionHard(questionHard);
        
        if (questionList.size() != 0) {
        	jsonObject.put("data", questionList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 多条件获取question
	 * @param question Question
	 * @return List
	 * */
	@RequestMapping(value = "/getQuestionByOtherCondition", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getQuestionByOtherCondition(@RequestBody Question question) {
		
		JSONObject jsonObject = returnDataInit.initSetting();        
        
        List<Question> questionList = questionService.getQuestionByOtherCondition(question);
        
        if (questionList.size() != 0) {
        	jsonObject.put("data", questionList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 多条件获取question(questionType判断条件为<=)
	 * @param question Question
	 * @return List
	 * */
	@RequestMapping(value = "/getQuestionByOtherCondition2", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getQuestionByOtherCondition2(@RequestBody Question question) {
		
		JSONObject jsonObject = returnDataInit.initSetting();        
        
        List<Question> questionList = questionService.getQuestionByOtherCondition2(question);
        
        if (questionList.size() != 0) {
        	jsonObject.put("data", questionList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	
	/**
	  * 根据paperId获取所有未选择的question
	  * @param paperId
	  * @return List
	  * */
	@RequestMapping(value = "/getAllUnchoiceQuestion", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllUnchoiceQuestion(int paperId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();        
        
        List<Question> questionList = questionService.getAllUnchoiceQuestion(paperId);
        
        if (questionList.size() != 0) {
        	jsonObject.put("data", questionList);  	
		} else {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 添加question
	 * @param question Question
	 * @return int
	 * */
	@RequestMapping(value = "/insertQuestion", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject insertQuestion(@RequestBody Question question) {
		System.out.println(question);
		JSONObject jsonObject = returnDataInit.initSetting();       
        
        int status = questionService.insertQuestion(question);
        System.out.println(status);
        if (status!=1) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 更新question
	 * @param question Question
	 * @return int
	 * */
	@RequestMapping(value = "/updateQuestion", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updateQuestion(@RequestBody Question question) {
		
		JSONObject jsonObject = returnDataInit.initSetting();       
        
        int status = questionService.updateQuestion(question);
        
        if (status!=1) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 刪除question
	 * @param question Question
	 * @return int
	 * */
	@RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject deleteQuestion( int questionId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();       
        
        int status = questionService.deleteQuestion(questionId);
        
        if (status!=1) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
	/**
	 * 批量删除question
	 * @param questionId
	 * @return JSONObject
	 * */
	@RequestMapping(value = "/deleteQuestionByBatch", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteQuestionByBatch (@RequestBody int[] questionId) {
		
		JSONObject jsonObject = returnDataInit.initSetting();       
        
        int status = questionService.deleteQuestionByBatch(questionId);
        
        if (status<=0) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "error");
		}
        return jsonObject;
	}
	
}
