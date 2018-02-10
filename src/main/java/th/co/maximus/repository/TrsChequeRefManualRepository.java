package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.TrsChequeRefManualBean;

@Repository("trsChequeRefManualRepository")
public interface TrsChequeRefManualRepository extends JpaRepository<TrsChequeRefManualBean, Long>{

}
