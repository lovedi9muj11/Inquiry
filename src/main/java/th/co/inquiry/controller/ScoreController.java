package th.co.inquiry.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.inquiry.constants.Constants;
import th.co.inquiry.model.ScoreBean;
import th.co.inquiry.service.MasterDataService;
import th.co.inquiry.service.ScoreService;
import th.co.inquiryx.bean.ResponscApi;

@Controller
@RequestMapping(value = "/score/")
public class ScoreController {
	
	@Autowired
	MasterDataService masterDataService;
	
	@Autowired
	ScoreService scoreService;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public ResponscApi save(@RequestBody ScoreBean score, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponscApi responscApi = new ResponscApi();
		String status = Constants.FAIL;
		try {
			scoreService.save(score);
			status = Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		responscApi.setMessage(status);

		return responscApi;
	}
	
	@RequestMapping(value = "findById/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ScoreBean findById(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		ScoreBean scoreBean = new ScoreBean();
		try {
			scoreBean = scoreService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return scoreBean;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponscApi delete(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		ResponscApi responscApi = new ResponscApi();
		String status = Constants.FAIL;
		try {
			scoreService.delete(id);
			status = Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		responscApi.setMessage(status);

		return responscApi;
	}
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ScoreBean> findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ScoreBean> list = new ArrayList<ScoreBean>();
		try {
			list = scoreService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
