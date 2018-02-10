package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.model.MasterReceiptHeaderMappingModel;

@Repository("masterReceiptHeaderMappingRepository")
public interface MasterReceiptHeaderMappingRepository  extends JpaRepository<MasterReceiptHeaderMappingModel, Long>{

}
