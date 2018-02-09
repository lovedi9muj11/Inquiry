package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.TrsMethodManualBean;

@Repository("trsMethodManualRepository")
public interface TrsMethodManualRepository extends JpaRepository<TrsMethodManualBean, Long>{

}
