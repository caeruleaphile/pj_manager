package data.objects;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String role;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    public TeamMember(String name, String role, Project project) {
        this.name = name;
        this.role = role;
        this.project = project;
    }

    public TeamMember() { }


    public TeamMember(String name, String role, Long projectId) {
        this.name = name;
        this.role = role;
        this.project = new Project(projectId);
    }


}
