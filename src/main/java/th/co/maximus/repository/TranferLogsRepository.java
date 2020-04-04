package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.model.DeductionManualModel;
import th.co.maximus.model.TranferLogs;

@Repository("tranferLogsRepository")
public interface TranferLogsRepository extends JpaRepository<TranferLogs, Long> {

}
