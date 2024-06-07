package services;

import data.dao.RiskRepository;
import data.objects.Project;
import data.objects.Risk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskService {

    @Autowired
    RiskRepository riskRepository;

    public List<Risk> getAllRisksByProject(Project project) {
        return riskRepository.findAllByProject(project);
    }

    public void createRisk(String description, String status, Long project) {
        Risk risk = new Risk(description, status, project);
        riskRepository.save(risk);
    }

    public void deleteRisk(Long id) {
        riskRepository.deleteById(id);
    }

    public void updateRisk(String status, String description, Long id) {
        Risk risk = riskRepository.findRiskById(id);
        risk.setStatus(status);
        risk.setDescription(description);
        riskRepository.save(risk);
    }
}
