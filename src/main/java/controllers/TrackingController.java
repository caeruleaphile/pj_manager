package controllers;

import data.dao.EffortRepository;
import data.objects.Effort;
import data.objects.Project; // Import Project class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.EffortService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TrackingController {

    @Autowired
    private EffortService effortService;

    @Autowired
    private EffortRepository effortRepository;

    @PostMapping("add-effort")
    public String addEffort(@RequestParam Long projectId,
                            @RequestParam String date,
                            @RequestParam int requirementsAnalysis,
                            @RequestParam int designing,
                            @RequestParam int coding,
                            @RequestParam int testing,
                            @RequestParam int projectManagement) throws ParseException {

        Date parsedDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);

        Effort effort = new Effort();
        Project project = new Project();
        project.setId(projectId); // Set the project ID
        effort.setProject(project); // Set the entire project object
        effort.setDate(parsedDate);
        effort.setRequirementAnalysisHours(requirementsAnalysis);
        effort.setDesigningHours(designing);
        effort.setCodingHours(coding);
        effort.setTestingHours(testing);
        effort.setProjectManagementHours(projectManagement);

        effortService.updateEffort(effort);

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("update-effort")
    public String updateEffort(@RequestParam Long projectId,
                               @RequestParam Long id,
                               @RequestParam int requirementsAnalysis,
                               @RequestParam int designing,
                               @RequestParam int coding,
                               @RequestParam int testing,
                               @RequestParam int projectManagement) {

        Effort effort = effortService.getEffortById(id);

        effort.setRequirementAnalysisHours(requirementsAnalysis);
        effort.setDesigningHours(designing);
        effort.setCodingHours(coding);
        effort.setTestingHours(testing);
        effort.setProjectManagementHours(projectManagement);

        effortService.updateEffort(effort);

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("/delete-effort")
    public String deleteEffort(@RequestParam Long projectId,
                               @RequestParam Long id) {

        effortService.deleteEffortById(id);

        return "redirect:/view-project?id=" + projectId;
    }
}
