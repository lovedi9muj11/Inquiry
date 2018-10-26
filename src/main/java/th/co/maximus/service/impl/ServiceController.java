package th.co.maximus.service.impl;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceController {
	
	@Autowired PaymentManualServiceImpl serviceImpl;
	
	void paymanet() throws ParseException {
		serviceImpl.insertPaymentManual(null);
		serviceImpl.insertPaymentManual(null);
		serviceImpl.insertPaymentManual(null);
	}

}
