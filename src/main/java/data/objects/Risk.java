package data.objects;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Risk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Risk(String description, String status, Project project) {
        this.description = description;
        this.status = status;
        this.project = project;
    }

    public Risk() {}

    public Risk(String description, String status, Long projectId) {
        this.description = description;
        this.status = status;
        this.project = new Project();
        this.project.setId(projectId);
    }
}
