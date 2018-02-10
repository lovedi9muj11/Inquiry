package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.model.DeductionManualModel;

@Repository("deductionManualRepository")
public interface DeductionManualRepository extends JpaRepository<DeductionManualModel, Long> {

}
