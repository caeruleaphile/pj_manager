package data.objects;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Risk {
    @Id
    public Long id;
    public String description;
    public String status;
    @ManyToOne
    @JoinColumn(name = "project_id")
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
