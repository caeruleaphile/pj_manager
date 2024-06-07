package data.dao;

import data.objects.Project;
import data.objects.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    List<TeamMember> findAllByProject(Project project);
    TeamMember findTeamMemberById(Long teamMemberId);
}
