// GeneralController.java

package controllers;

import data.dao.*;
import data.objects.*;
import services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GeneralController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RiskService riskService;

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private TeamMemberService teamMemberService;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @GetMapping("/update-description")
    public String updateProjectDescription(HttpServletRequest request) {
        String id = request.getParameter("projectId");
        String description = request.getParameter("description");

        Project project = projectService.getProjectById(Long.valueOf(id));
        project.setDescription(description);

        projectRepository.save(project);

        return "redirect:/";
    }

    @GetMapping("/update-project-manager")
    public String updateProjectManager(HttpServletRequest request) {
        String id = request.getParameter("projectId");
        String manager = request.getParameter("projectManager"); // Corrected parameter name

        Project project = projectService.getProjectById(Long.valueOf(id));
        project.setManager(manager);

        projectRepository.save(project);

        return "redirect:/";
    }

    @PostMapping("/create-risk")
    public String createRisk(HttpServletRequest request) {
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String projectId = request.getParameter("projectId");

        riskService.createRisk(description, status, Long.valueOf(projectId)); // Convert String to Long

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("/delete-risk")
    public String deleteRisk(HttpServletRequest request) {
        String id = request.getParameter("risk");
        String projectId = request.getParameter("projectId");

        riskService.deleteRisk(Long.valueOf(id));

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("/edit-risk")
    public String editRisk(HttpServletRequest request) {
        String id = request.getParameter("riskId");
        String projectId = request.getParameter("projectId");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        riskService.updateRisk(status, description, Long.valueOf(id));

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("/create-team-member")
    public String createTeamMember(HttpServletRequest request) {
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String projectId = request.getParameter("projectId");

        teamMemberService.createTeamMember(name, role, Long.valueOf(projectId));

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("/delete-team-member")
    public String deleteTeamMember(HttpServletRequest request) {
        String id = request.getParameter("member");
        String projectId = request.getParameter("projectId");

        teamMemberService.deleteTeamMember(Long.valueOf(id));

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("/edit-team-member")
    public String editTeamMember(HttpServletRequest request) {
        String id = request.getParameter("teamMemberId");
        String projectId = request.getParameter("projectId");
        String name = request.getParameter("name");
        String role = request.getParameter("role");

        teamMemberService.updateTeamMember(name, role, Long.valueOf(id));

        return "redirect:/view-project?id=" + projectId;
    }
}
