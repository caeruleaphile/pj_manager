package data.objects;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String role;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public TeamMember(String name, String role, Project project) {
        this.name = name;
        this.role = role;
        this.project = project;
    }

    public TeamMember() {}

    public TeamMember(String name, String role, Long projectId) {
        this.name = name;
        this.role = role;
        this.project = new Project(projectId);
    }
}
