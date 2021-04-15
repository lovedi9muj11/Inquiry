package th.co.inquiry.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.inquiry.auth.model.UserProfile;
import th.co.inquiry.constants.Constants;
import th.co.inquiry.service.MasterDataService;
import th.co.inquiryx.bean.MasterDataBean;
import th.co.inquiryx.bean.ResponscApi;

@Controller
public class MasterDataController {

	@Autowired
	MasterDataService masterDataService;
	
	@RequestMapping(value = { "/create-master-data" }, method = RequestMethod.GET)
	public String createmasterData(Model model) {
		return "create-master-data";
	}

	@RequestMapping(value = { "/create-master-data-group" }, method = RequestMethod.GET)
	public String createGroup(Model model) {
		return "create-master-data-group";
	}
	
	@RequestMapping(value = { "/insertBatch" }, method = RequestMethod.GET)
	public String insertBatch(Model model) {
		return "manageBatch";
	}

	@RequestMapping(value = "/insertMasterdata", method = RequestMethod.POST)
	@ResponseBody
	public String insert(Model model, @RequestBody MasterDataBean masterDataBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int paymentId = 0;
		try {
			paymentId = masterDataService.insert(masterDataBean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(paymentId);
	}

	@RequestMapping(value = "/insertMasterdataGroup", method = RequestMethod.POST)
	@ResponseBody
	public ResponscApi insertMasterdataGroup(@RequestBody MasterDataBean masterDataBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponscApi responscApi = new ResponscApi();
		String status = Constants.FAIL;
		int paymentId = 0;
		try {
			paymentId = masterDataService.insertGroup(masterDataBean);
			status = Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		responscApi.setMessage(status);
		responscApi.setId(paymentId);

		return responscApi;
	}
	
	@RequestMapping(value = "/findGroupTypeByKeyCode", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public MasterDataBean findGroupTypeByKeyCode(@RequestBody MasterDataBean masterDataBean, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MasterDataBean masterData = new MasterDataBean();
		try {
			masterData = masterDataService.findGroupTypeByKeyCode(masterDataBean.getGroup());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return masterData;
	}
	
	@RequestMapping(value = "/findQuestionByKeyCode", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public MasterDataBean findQuestionByKeyCode(@RequestBody MasterDataBean masterDataBean, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MasterDataBean masterData = new MasterDataBean();
		try {
			masterData = masterDataService.findGroupTypeByKeyCode(masterDataBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return masterData;
	}
	
	@RequestMapping(value = "/findQuestionByGroup", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<MasterDataBean> findQuestionByGroup(@RequestBody MasterDataBean masterDataBean, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MasterDataBean> masterDatas = new ArrayList<MasterDataBean>();
		try {
			masterDatas = masterDataService.findQuestionByGroupKey(masterDataBean.getGroup());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return masterDatas;
	}
	
	@RequestMapping(value = "/findQuestionTypeByGroup", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MasterDataBean> findQuestionTypeByGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MasterDataBean> masterDatas = new ArrayList<MasterDataBean>();
		try {
			masterDatas = masterDataService.findQuestionByGroupKey(Constants.QUESTION_TYPE_DD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return masterDatas;
	}
	
	@RequestMapping(value = "/findAllQuestion", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MasterDataBean> findAllQuestion(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MasterDataBean> masterDatas = new ArrayList<MasterDataBean>();
		try {
			masterDatas = masterDataService.findQuestion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return masterDatas;
	}
	
	@RequestMapping(value = "/saveMasterdata", method = RequestMethod.POST)
	@ResponseBody
	public ResponscApi save(@RequestBody MasterDataBean masterDataBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponscApi responscApi = new ResponscApi();
		String status = Constants.FAIL;
		try {
			masterDataService.save(masterDataBean);
			status = Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responscApi.setMessage(status);

		return responscApi;
	}
	
	@RequestMapping(value = "/getTypeQuestion", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MasterDataBean> findByGroupCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MasterDataBean> masterDataBeans = new ArrayList<MasterDataBean>();
		try {
			masterDataBeans = masterDataService.findGroupTypeByGroupKey(Constants.QUESTION_TYPE_DD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return masterDataBeans;
	}
	
	@RequestMapping(value = "/getQuestionDD", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MasterDataBean> getQuestionDD(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MasterDataBean> masterDataBeans = new ArrayList<MasterDataBean>();
		try {
			masterDataBeans = masterDataService.findAll4DropDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return masterDataBeans;
	}
	
	@RequestMapping(value = "/getQuestion", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MasterDataBean> getQuestion(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MasterDataBean> masterDataBeans = new ArrayList<MasterDataBean>();
		try {
			masterDataBeans = masterDataService.findAllQuestion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return masterDataBeans;
	}
	
	@RequestMapping(value = "/findAllMasterData", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MasterDataBean> findAllMasterData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MasterDataBean> masterDataList = new ArrayList<MasterDataBean>();
		try {
			masterDataList = masterDataService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return masterDataList;
	}
	
	@RequestMapping(value = "/masterData/delete", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponscApi delete(@RequestBody MasterDataBean masterDataBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponscApi responscApi = new ResponscApi();
		String status = Constants.FAIL;
		try {
			UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			masterDataService.delete(masterDataBean, profile.getUsername());
			status = Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		responscApi.setMessage(status);

		return responscApi;
	}
	
	@RequestMapping(value = "/masterData/findByGroupKey/{group}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MasterDataBean> findByGroupKey(HttpServletRequest request, HttpServletResponse response, @PathVariable("group") String group) throws Exception {
		List<MasterDataBean> masterDataList = new ArrayList<MasterDataBean>();
		try {
			masterDataList = masterDataService.findQuestionByGroupKey(group);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return masterDataList;
	}
	
	@RequestMapping(value = "/saveReport", method = RequestMethod.POST)
	@ResponseBody
	public ResponscApi saveReport(@RequestBody MasterDataBean masterDataBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponscApi responscApi = new ResponscApi();
		String status = Constants.FAIL;
		try {
			masterDataBean.setGroup(Constants.QUESTION_REPORT);
			masterDataService.save(masterDataBean);
			status = Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responscApi.setMessage(status);

		return responscApi;
	}
	
	@RequestMapping(value = "/findAllReport", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MasterDataBean> findAllReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MasterDataBean> masterDataBeans = new ArrayList<MasterDataBean>();
		try {
			masterDataBeans = masterDataService.findQuestionByGroupKey(Constants.QUESTION_REPORT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return masterDataBeans;
	}
	
	@RequestMapping(value = "/findAllReportPage/{rptCode}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public MasterDataBean findAllReportPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("rptCode") String rptCode) throws Exception {
		MasterDataBean masterData = new MasterDataBean();
		try {
			masterData = masterDataService.findReportByCode(rptCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return masterData;
	}
	
	@RequestMapping(value = "/masterData/findById/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public MasterDataBean findById(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		MasterDataBean masterData = new MasterDataBean();
		try {
			masterData = masterDataService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return masterData;
	}
	
}
