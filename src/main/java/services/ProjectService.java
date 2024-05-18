package services;

import data.dao.ProjectRepository;
import data.objects.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    public Project getProjectByName(String name) {
        return projectRepository.findByName(name);
    }

    public Project getProjectById(Long id) {
        return projectRepository.findProjectById(id);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);

    }
    public Project createProject(String name, String description, String manager) {
        Project project = new Project(name, description, manager);
        return projectRepository.save(project);

    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
