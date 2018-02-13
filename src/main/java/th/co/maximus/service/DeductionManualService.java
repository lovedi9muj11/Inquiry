package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.DeductionManualBean;
import th.co.maximus.payment.bean.PaymentFirstBean;

public interface DeductionManualService {

	void insertDeductionManual(DeductionManualBean deductionManualBean);

	List<DeductionManualBean> DeductionManualAll();



	

}
