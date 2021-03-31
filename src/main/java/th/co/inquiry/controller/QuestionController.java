package th.co.inquiry.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.inquiry.auth.model.UserProfile;
import th.co.inquiry.model.QuestionBean;
import th.co.inquiry.service.QuestionService;

@Controller
@RequestMapping(value = "/question/")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;

	@RequestMapping(value = "findById/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public QuestionBean findById(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		QuestionBean question = new QuestionBean();
		try {
			question = questionService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return question;
	}
	
	@RequestMapping(value = "findByType/{type}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<QuestionBean> findByType(HttpServletRequest request, HttpServletResponse response, @PathVariable("type") String type) throws Exception {
		List<QuestionBean> questions = new ArrayList<QuestionBean>();
		try {
			questions = questionService.findByType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return questions;
	}
	
	@RequestMapping(value = "findByGroupCode/{code}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<QuestionBean> findByGroupCode(HttpServletRequest request, HttpServletResponse response, @PathVariable("code") String code) throws Exception {
		List<QuestionBean> questions = new ArrayList<QuestionBean>();
		try {
			questions = questionService.findByGroupCode(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return questions;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public void save(@RequestBody QuestionBean questionBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			questionBean.setUserId(profile.getUsername());
			questionService.save(questionBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
