package data.dao;

import data.objects.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RiskRepository extends JpaRepository<Risk, Long> {
    List<Risk> findAllByProjectId(Long projectId);

    Risk findRiskById(Long id);
}
