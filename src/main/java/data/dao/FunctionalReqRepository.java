package data.dao;

import data.objects.FunctionalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FunctionalReqRepository extends JpaRepository<FunctionalRequirement, Long> {
    List<FunctionalRequirement> findAllByProjectId(Long projectId);
    FunctionalRequirement findFunctionalRequirementById(Long id);

}
