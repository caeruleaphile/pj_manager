package controllers;

import data.dao.FunctionalReqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.RequirementService;

@Controller
public class RequirementsController {

    @Autowired
    private FunctionalReqRepository functionalReqRepository;

    @Autowired
    private RequirementService requirementService;

    @PostMapping("/create-functional-requirement")
    public String createFunctionalRequirement(
            @RequestParam("functionalRequirement") String requirement,
            @RequestParam("projectId") Long projectId) {

        requirementService.createFunctionalRequirement(requirement, projectId);

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("/delete-functional-requirement")
    public String deleteFunctionalRequirement(
            @RequestParam("functionalRequirementId") Long id,
            @RequestParam("projectId") Long projectId) {

        requirementService.deleteFunctionalRequirement(id);

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("/edit-functional-requirement")
    public String editFunctionalRequirement(
            @RequestParam("requirementId") Long id,
            @RequestParam("projectId") Long projectId,
            @RequestParam("functionalRequirement") String requirement) {

        requirementService.updateFunctionalRequirement(requirement, id);

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("/create-non-functional-requirement")
    public String createNonFunctionalRequirement(
            @RequestParam("nonFunctionalRequirement") String requirement,
            @RequestParam("projectId") Long projectId) {

        requirementService.createNonFunctionalRequirement(requirement, projectId);

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("/delete-non-functional-requirement")
    public String deleteNonFunctionalRequirement(
            @RequestParam("nonFunctionalRequirementId") Long id,
            @RequestParam("projectId") Long projectId) {

        requirementService.deleteNonFunctionalRequirement(id);

        return "redirect:/view-project?id=" + projectId;
    }

    @PostMapping("/edit-non-functional-requirement")
    public String editNonFunctionalRequirement(
            @RequestParam("requirementId") Long id,
            @RequestParam("projectId") Long projectId,
            @RequestParam("nonFunctionalRequirement") String requirement) {

        requirementService.updateNonFunctionalRequirement(requirement, id);

        return "redirect:/view-project?id=" + projectId;
    }
}
