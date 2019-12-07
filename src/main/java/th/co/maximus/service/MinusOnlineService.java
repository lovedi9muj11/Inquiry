package th.co.maximus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;

@Service
public interface MinusOnlineService {
	void updateStatusForMinusOnline(List<PaymentMMapPaymentInvBean> creteria) throws Exception;
}
