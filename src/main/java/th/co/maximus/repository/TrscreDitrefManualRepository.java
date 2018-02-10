package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.TrscreDitrefManualBean;

@Repository("trscreDitrefManualRepository")
public interface TrscreDitrefManualRepository extends JpaRepository<TrscreDitrefManualBean, Long>{

}
