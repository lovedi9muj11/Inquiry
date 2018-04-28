package th.co.maximus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.GroupTypeDropdown;
import th.co.maximus.bean.MasterDataBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.dao.MasterDataDao;
import th.co.maximus.service.MasterDataService;

@Service
public class MasterDataServiceImpl implements MasterDataService{
	
	@Autowired
	MasterDataDao masterDataDao;
	@Autowired
	MasterDataService masterDataService;
	
	List<GroupTypeDropdown> groupTypeDropdownList;
	GroupTypeDropdown groupTypeDropdown;

	@Override
	public List<MasterDataBean> findAllByBankCode() {
		List<MasterDataBean> masterDataList = masterDataDao.findAllByBankCode();
		
		return masterDataList;
	}

	@Override
	public List<MasterDataBean> findAllByBankName() {
		List<MasterDataBean> masterDataList = masterDataDao.findAllByBankName();
		return masterDataList;
	}

	@Override
	public List<GroupTypeDropdown> findAll() {
		groupTypeDropdownList = new ArrayList<GroupTypeDropdown>();
		groupTypeDropdown = new GroupTypeDropdown();
		
		List<MasterDataBean> list = masterDataDao.findAll();
		
		if(CollectionUtils.isNotEmpty(list)) {
			groupTypeDropdown.setName(Constants.MasterData.SELECT_DROPDOWN);
			groupTypeDropdown.setValue("");
			groupTypeDropdownList.add(groupTypeDropdown);
			for(int i=0; i<list.size(); i++) {
				groupTypeDropdown = new GroupTypeDropdown();
				groupTypeDropdown.setName(list.get(i).getText());
				groupTypeDropdown.setValue(list.get(i).getValue());
				groupTypeDropdownList.add(groupTypeDropdown);
			}
		}
		
		return groupTypeDropdownList;
	}
	
	
	@Override
	public int insert(MasterDataBean masterDataBean) {

		int masterId =0;
		
		MasterDataBean bean = new MasterDataBean();
		bean.setValue(masterDataBean.getValue());
		bean.setText(masterDataBean.getText());
		bean.setGroup(masterDataBean.getGroup());
		
		
		try {
				
			masterId = masterDataDao.insertMasterdata(masterDataBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return masterId;
	}
	@Override
	public int insertGroup(MasterDataBean masterDataBean) {

		int masterId =0;
		
		MasterDataBean bean = new MasterDataBean();
		bean.setValue(masterDataBean.getValue());
		bean.setText(masterDataBean.getValue());
		
		
		try {
				
			masterId = masterDataDao.insertMasterdataGroup(masterDataBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return masterId;
	}
	
	@Override
	public List<MasterDataBean> findAllByServiceType() {
		List<MasterDataBean> masterDataList = masterDataDao.findAllByServiceType();
		return masterDataList;
	}
	@Override
	public List<MasterDataBean> findAllByServiceDepartment() {
		List<MasterDataBean> masterDataList = masterDataDao.findAllByServiceDepartment();
		return masterDataList;
	}
	@Override
	public List<MasterDataBean> findAllByServiceName() {
		List<MasterDataBean> masterDataList = masterDataDao.findAllByServiceName();
		return masterDataList;
	}
	@Override
	public List<MasterDataBean> findAllByCategory() {
		List<MasterDataBean> masterDataList = masterDataDao.findAllByCategory();
		return masterDataList;
	}

}
