package data.objects;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class Effort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long projectId;
    @Column(nullable = false)
    private int requirementAnalysisHours;
    @Column(nullable = false)
    private int designingHours;
    @Column(nullable = false)
    private int codingHours;
    @Column(nullable = false)
    private int testingHours;
    @Column(nullable = false)
    private int projectManagementHours;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    public Effort(Long id,Long projectId) {
        this.id = id;
        this .projectId=projectId;
    }
    public Effort() {}



}

