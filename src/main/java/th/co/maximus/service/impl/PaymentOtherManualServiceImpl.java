package th.co.maximus.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.MasterDataBean;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.dao.MasterDataDao;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;
import th.co.maximus.service.MasterDataService;
import th.co.maximus.service.PaymentOtherManualService;
@Service
public class PaymentOtherManualServiceImpl implements PaymentOtherManualService{
	@Autowired
	PaymentManualDao paymentManualDao;
	
	@Autowired
	MasterDataDao masterDataDao;
	
	@Autowired
	MasterDataService masterDataService;

	@Override
	public int insertPaymentManual(PaymentOtherFirstBean paymentBean) {
		//UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<MasterDataBean> serviceDepartmentList = new ArrayList<>();
		serviceDepartmentList = masterDataService.findAllByServiceDepartment();
		MasterDataBean branch = masterDataDao.findAllByBranchcode();
		PaymentManualBean paymentManualBean = new PaymentManualBean();
		Date date = new Date();
		int userId=0;
		String brancharea = "";
		if(StringUtils.isNotBlank(paymentBean.getDocumentNo())){
			paymentManualBean.setReceiptNoManual(paymentBean.getDocumentNo());
			for(int x = 0 ; x <serviceDepartmentList.size(); x++ ) {
				if(StringUtils.isNotBlank(serviceDepartmentList.get(x).getValue()))if(serviceDepartmentList.get(x).getValue().equals(branch.getText())) {
					brancharea = serviceDepartmentList.get(x).getValue();
				}
			}
			
			paymentManualBean.setBrancharea(brancharea); //-- maew24012020
			paymentManualBean.setBranchCode(paymentBean.getCustBrach());
			paymentManualBean.setPaidAmount(paymentBean.getBalanceSummary());
			paymentManualBean.setAmount(new BigDecimal(paymentBean.getBalanceSummary()));
			paymentManualBean.setVatAmount(new BigDecimal(paymentBean.getVats()));
			paymentManualBean.setSource(Constants.dataUser.SOURCE);
			paymentManualBean.setClearing("N");
			paymentManualBean.setRemark(paymentBean.getRemark());
			paymentManualBean.setCreateBy(paymentBean.getUserName());
			paymentManualBean.setCreateDate(new Timestamp(date.getTime()));
			paymentManualBean.setUpdateBy(paymentBean.getUserName());
			paymentManualBean.setUpdateDate(new Timestamp(date.getTime()));
			paymentManualBean.setRecordStatus("A");
			paymentManualBean.setChange(paymentBean.getChange());
			paymentManualBean.setAccountNo(paymentBean.getCustNo());
			paymentManualBean.setDocType(paymentBean.getDocType());
			
			paymentManualBean.setPaytype("F");
			paymentManualBean.setCustomerGroup(paymentBean.getUserGroup());
			paymentManualBean.setSegmentCode(paymentBean.getSegmentCode());
			paymentManualBean.setProductCode(paymentBean.getProductCode());
			
			try {
				userId=	paymentManualDao.insertPayment(paymentManualBean);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return userId;
	}



	
	@Override
	public List<PaymentManualBean> PaymentManualAll() {
		return null;
	}
	
	/*public PaymentManualBean xx() {
		return jdbcTemplate.queryForObject("select * from payment_manual", new PaymentManuaJoin());
	}*/
}
