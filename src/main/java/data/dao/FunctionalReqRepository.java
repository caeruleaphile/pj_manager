// FunctionalReqRepository.java

package data.dao;

import data.objects.FunctionalRequirement;
import data.objects.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FunctionalReqRepository extends JpaRepository<FunctionalRequirement, Long> {
    List<FunctionalRequirement> findAllByProjectId(Long projectId);
    List<FunctionalRequirement> findAllByProject(Project project);

}
