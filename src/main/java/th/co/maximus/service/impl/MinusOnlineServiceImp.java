package th.co.maximus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.dao.MinusOnlineDao;
import th.co.maximus.service.MinusOnlineService;

@Service
public class MinusOnlineServiceImp implements MinusOnlineService {
	
	@Autowired MinusOnlineDao minusOnlineDao;

	@Override
	public void updateStatusForMinusOnline(List<PaymentMMapPaymentInvBean> creteria) throws Exception {
//		for(PaymentMMapPaymentInvBean invBean : creteria) {
//			minusOnlineDao.updateStatusForMinusOnline(invBean);
//		}
	}

}
