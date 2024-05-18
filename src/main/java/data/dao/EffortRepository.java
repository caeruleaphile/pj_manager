package data.dao;

import data.objects.Effort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EffortRepository extends JpaRepository<Effort,Long> {
     List<Effort> findAllByProjectId(Long projectId);
     Effort findEffortById(Long id);
     Effort findEffortByDate(Date date);


}
