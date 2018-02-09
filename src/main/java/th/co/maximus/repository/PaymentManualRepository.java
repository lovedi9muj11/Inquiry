package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.PaymentManualBean;

@Repository("paymentManualRepository")
public interface PaymentManualRepository extends JpaRepository<PaymentManualBean, Long> {

	
	
	
}
