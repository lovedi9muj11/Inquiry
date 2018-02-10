package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.model.ArcprincipalModel;

@Repository("arcprincipalRepository")
public interface ArcprincipalRepository extends JpaRepository<ArcprincipalModel, Long> {
	

}
