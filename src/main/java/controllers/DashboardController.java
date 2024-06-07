package controllers;

import data.dao.*;
import data.objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class DashboardController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    private FunctionalReqRepository functionalReqRepository;

    @Autowired
    private NonFunctionalReqRepository nonFunctionalReqRepository;

    @Autowired
    private EffortRepository effortRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        model.addAttribute("hasNoProjects", projects.isEmpty());
        return "dashboard";
    }

    @PostMapping("/create-project")
    public String createProject(HttpServletRequest request) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String manager = request.getParameter("manager");

        Project project = new Project(name, description, manager);
        projectRepository.save(project);

        return "redirect:/dashboard";
    }

    @GetMapping("/view-project")
    public String viewProject(Model model, @RequestParam Long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            model.addAttribute("project", project);

            List<Risk> risks = riskRepository.findAllByProject(project);
            model.addAttribute("risks", risks);

            List<TeamMember> teamMembers = teamMemberRepository.findAllByProject(project);
            model.addAttribute("team", teamMembers);

            List<FunctionalRequirement> functionalRequirements = functionalReqRepository.findAllByProject(project);
            model.addAttribute("functionalRequirements", functionalRequirements);

            List<NonFunctionalRequirement> nonFunctionalRequirements = nonFunctionalReqRepository.findAllByProject(project);
            model.addAttribute("nonFunctionalRequirements", nonFunctionalRequirements);

            List<Effort> effortList = effortRepository.findAllByProject(project);
            model.addAttribute("effortList", effortList);

            // Calculate total hours and distribution
            int totalHours = 0;
            int requirementAnalysisHours = 0;
            int codingHours = 0;
            int testingHours = 0;
            int designingHours = 0;
            int projectManagementHours = 0;

            for (Effort effort : effortList) {
                codingHours += effort.getCodingHours();
                testingHours += effort.getTestingHours();
                designingHours += effort.getDesigningHours();
                projectManagementHours += effort.getProjectManagementHours();
                requirementAnalysisHours += effort.getRequirementAnalysisHours();
            }

            totalHours = codingHours + testingHours + designingHours + projectManagementHours + requirementAnalysisHours;

            model.addAttribute("codingTotal", codingHours);
            model.addAttribute("testingTotal", testingHours);
            model.addAttribute("designingTotal", designingHours);
            model.addAttribute("projectMgtTotal", projectManagementHours);
            model.addAttribute("requirementAnalysisTotal", requirementAnalysisHours);
            model.addAttribute("totalHours", totalHours);

            // Calculate distribution percentages
            double codingDistribution = (double) codingHours / totalHours * 100;
            double testingDistribution = (double) testingHours / totalHours * 100;
            double designingDistribution = (double) designingHours / totalHours * 100;
            double projectMgtDistribution = (double) projectManagementHours / totalHours * 100;
            double requirementAnalysisDistribution = (double) requirementAnalysisHours / totalHours * 100;

            // Add distribution percentages to the model
            model.addAttribute("codingDistribution", codingDistribution);
            model.addAttribute("testingDistribution", testingDistribution);
            model.addAttribute("designingDistribution", designingDistribution);
            model.addAttribute("projectMgtDistribution", projectMgtDistribution);
            model.addAttribute("requirementAnalysisDistribution", requirementAnalysisDistribution);

            return "view-project";
        } else {
            return "error"; // Or handle appropriately
        }
    }

    @PostMapping("/delete-project")
    public String deleteProject(@ModelAttribute Project project) {
        Long id = project.getId();
        projectRepository.deleteById(id);
        return "redirect:/dashboard";
    }
}
