package data.objects;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String description;
    public String manager;

    @OneToMany(mappedBy = "project")
    private List<FunctionalRequirement> functionalRequirements;

    @OneToMany(mappedBy = "project")
    private List<NonFunctionalRequirement> nonFunctionalRequirements;

    @OneToMany(mappedBy = "project")
    private List<Risk> risks;

    @OneToMany(mappedBy = "project")
    private List<TeamMember> teamMembers;

    public Project(){}
    public Project(String name, String description, String manager) {
        this.name = name;
        this.description = description;
        this.manager = manager;
    }


    public Project(Long projectId) {
        this.id = projectId;
    }
}
