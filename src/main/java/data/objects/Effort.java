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
    private Long projectId;
    private int requirementAnalysisHours;
    private int designingHours;
    private int codingHours;
    private int testingHours;
    private int projectManagementHours;
    private Date date;

    public Effort(Long id,Long projectId) {
        this.id = id;
        this .projectId=projectId;
    }
    public Effort() {}



}

