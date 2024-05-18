package data.dao;

import data.objects.NonFunctionalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NonFunctionalReqRepository extends JpaRepository<NonFunctionalRequirement,Long> {
    List<NonFunctionalRequirement> findAllByProjectId(Long projectId);

    NonFunctionalRequirement findNonFunctionalRequirementById(Long id);
}
