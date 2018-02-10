package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.MasOfficerBean;

@Repository("masOfficerRepository")
public interface MasOfficerRepository extends JpaRepository<MasOfficerBean, Long>{

}
