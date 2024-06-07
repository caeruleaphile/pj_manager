// RequirementService.java

package services;

import data.dao.FunctionalReqRepository;
import data.dao.NonFunctionalReqRepository;
import data.objects.FunctionalRequirement;
import data.objects.NonFunctionalRequirement;
import data.objects.Project; // Added import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementService {

    @Autowired
    private FunctionalReqRepository functionalReqRepository;

    @Autowired
    private NonFunctionalReqRepository nonFunctionalReqRepository;

    public List<FunctionalRequirement> getAllFunctionalRequirementsByProjectId(Long projectId) {
        return functionalReqRepository.findAllByProjectId(projectId); // Corrected method call
    }

    public void createFunctionalRequirement(String requirement, Long projectId) {
        FunctionalRequirement functionalRequirement = new FunctionalRequirement(requirement, projectId);
        functionalReqRepository.save(functionalRequirement);
    }

    public void deleteFunctionalRequirement(Long id) {
        functionalReqRepository.deleteById(id);
    }

    public void updateFunctionalRequirement(String requirement, Long id) {
        FunctionalRequirement functionalRequirement = functionalReqRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Functional Requirement with id " + id + " not found"));
        functionalRequirement.setRequirement(requirement);
        functionalReqRepository.save(functionalRequirement);
    }

    public List<NonFunctionalRequirement> getAllNonFunctionalRequirementsByProjectId(Long projectId) {
        return nonFunctionalReqRepository.findAllByProjectId(projectId);
    }

    public void createNonFunctionalRequirement(String requirement, Long projectId) {
        NonFunctionalRequirement nonFunctionalRequirement = new NonFunctionalRequirement(requirement, projectId);
        nonFunctionalReqRepository.save(nonFunctionalRequirement);
    }

    public void deleteNonFunctionalRequirement(Long id) {
        nonFunctionalReqRepository.deleteById(id);
    }

    public void updateNonFunctionalRequirement(String requirement, Long id) {
        NonFunctionalRequirement nonFunctionalRequirement = nonFunctionalReqRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Non-Functional Requirement with id " + id + " not found"));
        nonFunctionalRequirement.setRequirement(requirement);
        nonFunctionalReqRepository.save(nonFunctionalRequirement);
    }
}
