package data.dao;

import data.objects.Effort;
import data.objects.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EffortRepository extends JpaRepository<Effort, Long> {
     List<Effort> findAllByProject(Project project);
     Effort findEffortById(Long id);
     Effort findByDate(Date date);
}
