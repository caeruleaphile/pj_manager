package data.objects;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Effort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    @NotNull
    private Project project;

    @Column(nullable = false)
    @Min(0)
    private int requirementAnalysisHours;

    @Column(nullable = false)
    @Min(0)
    private int designingHours;

    @Column(nullable = false)
    @Min(0)
    private int codingHours;

    @Column(nullable = false)
    @Min(0)
    private int testingHours;

    @Column(nullable = false)
    @Min(0)
    private int projectManagementHours;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;

    public Effort(Long id, Project project) {
        this.id = id;
        this.project = project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
