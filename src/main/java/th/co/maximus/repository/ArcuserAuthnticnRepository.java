package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.ArcuserAuthnticnBean;

@Repository("arcuserAuthnticnRepository")
public interface ArcuserAuthnticnRepository extends JpaRepository<ArcuserAuthnticnBean, Long>{

}
