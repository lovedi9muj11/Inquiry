package th.co.maximus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.model.CorreceiptDocumentModel;

@Repository("correceiptDocumentRepository")
public interface CorreceiptDocumentRepository extends JpaRepository<CorreceiptDocumentModel, Long> {

}
