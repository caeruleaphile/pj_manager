package data.objects;

import lombok.*;
import javax.persistence.*;
@Entity
@Getter
@Setter
public class NonFunctionalRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String requirement;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    public NonFunctionalRequirement() {}
    public NonFunctionalRequirement(String requirement, Project project) {
        this.requirement = requirement;
        this.project = project;

    }

    public NonFunctionalRequirement(String requirement, Long projectId) {
        this.requirement = requirement;
        this.project = new Project();
        this.project.setId(projectId);
    }
}
