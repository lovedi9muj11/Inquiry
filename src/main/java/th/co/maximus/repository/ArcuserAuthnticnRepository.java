package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.model.ArcuserAuthnticnModel;

@Repository("arcuserAuthnticnRepository")
public interface ArcuserAuthnticnRepository extends JpaRepository<ArcuserAuthnticnModel, Long>{

}
