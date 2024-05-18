package data.objects;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class FunctionalRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false, length = 500)
    public String requirement;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public FunctionalRequirement() {}
    public FunctionalRequirement(String requirement, Project project) {
        this.requirement = requirement;
        this.project = project;
    }

    public FunctionalRequirement(String requirement, Long projectId) {
        this.requirement = requirement;
        this.project = new Project();
        this.project.setId(projectId);
    }

}
