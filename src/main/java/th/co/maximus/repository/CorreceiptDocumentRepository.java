package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.CorreceiptDocumentBean;

@Repository("correceiptDocumentRepository")
public interface CorreceiptDocumentRepository extends JpaRepository<CorreceiptDocumentBean, Long> {

}
