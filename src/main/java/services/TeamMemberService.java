package services;

import data.dao.TeamMemberRepository;
import data.objects.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    public List<TeamMember> getAllTeamMembersByProjectId(Long projectId) {
        return teamMemberRepository.findAllByProjectId(projectId);
    }

    public void createTeamMember(String name, String role, Long projectId) {
        TeamMember teamMember = new TeamMember(name, role, projectId);
        teamMemberRepository.save(teamMember);
    }

    public void deleteTeamMember(Long id) {
        teamMemberRepository.deleteById(id);
    }

    public void updateTeamMember(String name, String role, Long id) {
        teamMemberRepository.findById(id).ifPresent(teamMember -> {
            teamMember.setName(name);
            teamMember.setRole(role);
            teamMemberRepository.save(teamMember);
        });
    }
}
