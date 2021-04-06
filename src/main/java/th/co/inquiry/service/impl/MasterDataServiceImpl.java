package th.co.inquiry.service.impl;

import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.inquiry.auth.model.GroupTypeDropdown;
import th.co.inquiry.constants.Constants;
import th.co.inquiry.dao.MasterDataDao;
import th.co.inquiry.dao.UserDao;
import th.co.inquiry.model.UserBean;
import th.co.inquiry.service.MasterDataService;
import th.co.inquiryx.bean.MasterDataBean;

@Service
public class MasterDataServiceImpl implements MasterDataService {

	@Autowired
	private MasterDataDao masterDataDao;

	@Autowired
	MasterDataService masterDataService;

	@Autowired
	private UserDao userDao;

	List<GroupTypeDropdown> groupTypeDropdownList;
	GroupTypeDropdown groupTypeDropdown;
	
	@Override
	public void save(MasterDataBean masterDataBean) {
		if(masterDataBean.getId()>0) {
			masterDataDao.updateMasterdata(masterDataBean);
		}else {
			masterDataDao.insertMasterdata(masterDataBean);
		}
	}

	@Override
	public int insert(MasterDataBean masterDataBean) {

		int masterId = 0;

		MasterDataBean bean = new MasterDataBean();
		bean.setKeyCode(masterDataBean.getKeyCode());
		bean.setValue(masterDataBean.getValue());
		bean.setGroup(masterDataBean.getGroup());
		bean.setType(masterDataBean.getType());

		try {

			masterId = masterDataDao.insertMasterdata(masterDataBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return masterId;
	}

	@Override
	public int insertGroup(MasterDataBean masterDataBean) {

		int masterId = 0;

		MasterDataBean bean = new MasterDataBean();
		bean.setValue(masterDataBean.getValue());
		bean.setKeyCode(masterDataBean.getGroup());
		bean.setType("Group");

		try {

			masterId = masterDataDao.insertMasterdataGroup(bean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return masterId;
	}

	@Override
	public UserBean findByUsername(String username) throws SQLException {

		return userDao.findByUsername(username);
	}

	@Override
	public MasterDataBean findGroupTypeByKeyCode(String groupKey) {
		MasterDataBean masterDataBean = new MasterDataBean();
		masterDataBean = masterDataDao.findGroupTypeByKeyCode(groupKey);

		return masterDataBean;
	}

	String getMonthForInt(int num) {
		String month = "wrong";
		DateFormatSymbols dfs = new DateFormatSymbols(new Locale("th", "TH"));
		String[] months = dfs.getMonths();
		if (num >= 0 && num <= 11) {
			month = months[num];
		}
		return month;
	}

	@Override
	public UserBean findByUsernameFromRole(Long id) throws SQLException {

		return userDao.findByUsernameFromRole(id);
	}

	@Override
	public List<MasterDataBean> findGroupTypeByGroupKey(String groupKey) {
		List<MasterDataBean> masterDataBeans = new ArrayList<MasterDataBean>();
		masterDataBeans = masterDataDao.findAllByGropType(groupKey);

		return masterDataBeans;
	}

	@Override
	public List<MasterDataBean> findAll() {
		List<MasterDataBean> masterDataBeans = new ArrayList<MasterDataBean>();
		masterDataBeans = masterDataDao.findAll();

		return masterDataBeans;
	}

	@Override
	public void delete(MasterDataBean masterDataBean, String username) {
		masterDataDao.delete(masterDataBean.getId());
	}

	@Override
	public List<MasterDataBean> findAll4DropDown() {
		List<MasterDataBean> resp = new ArrayList<MasterDataBean>();
		List<MasterDataBean> masterDataBeans = new ArrayList<MasterDataBean>();
		masterDataBeans = masterDataDao.findAll();
		
		if(CollectionUtils.isNotEmpty(masterDataBeans)) {
			for(MasterDataBean data : masterDataBeans) {
				if(StringUtils.isBlank(data.getGroup())) {
					resp.add(data);
				}
			}
		}
		
		return resp;
	}

	@Override
	public List<MasterDataBean> findAllQuestion() {
		List<MasterDataBean> masterDataBeans = new ArrayList<MasterDataBean>();
		masterDataBeans = masterDataDao.findAllByGropKey(Constants.QUESTION);

		return masterDataBeans;
	}

	@Override
	public List<MasterDataBean> findQuestionByGroupKey(String groupKey) {
		List<MasterDataBean> masterDataBeans = new ArrayList<MasterDataBean>();
		masterDataBeans = masterDataDao.findAllByGropKey(groupKey);

		return masterDataBeans;
	}

	@Override
	public MasterDataBean findGroupTypeByKeyCode(MasterDataBean bean) {
		MasterDataBean masterDataBean = new MasterDataBean();
		masterDataBean = masterDataDao.findGroupTypeByKeyCode(bean.getGroup(), bean.getKeyCode());

		return masterDataBean;
	}

	@Override
	public List<MasterDataBean> findQuestion() {
		List<MasterDataBean> resps = new ArrayList<MasterDataBean>();
		MasterDataBean resp = new MasterDataBean();
		List<MasterDataBean> masterDataBeans = new ArrayList<MasterDataBean>();
		
		masterDataBeans = masterDataDao.findAllByGropKey(Constants.QUESTION);
		if(CollectionUtils.isNotEmpty(masterDataBeans)) {
			for(MasterDataBean data : masterDataBeans) {
				resp = new MasterDataBean();
				resp = data;
				List<MasterDataBean> res = masterDataDao.findAllByGropKey(data.getValue());
				resp.setList(res);
				
				resps.add(resp);
			}
		}

		return resps;
	}

}
