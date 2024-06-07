package data.objects;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FunctionalRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    @NotNull
    @Size(max = 500)
    private String requirement;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    @NotNull
    private Project project;

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
