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
    @Column(nullable = false, length = 100)
    public String name;
    @Column(length = 1000)
    public String description;
    @Column(nullable = false, length = 100)
    public String manager;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FunctionalRequirement> functionalRequirements;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NonFunctionalRequirement> nonFunctionalRequirements;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Risk> risks;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
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
