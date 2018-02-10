package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.model.PaymentMaualModel;

@Repository("paymentManualRepository")
public interface PaymentManualRepository extends JpaRepository<PaymentMaualModel, Long> {

	
	
	
}
