package pl.coderslab.springbootexample.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "goals")
@Data
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(columnDefinition = "VARCHAR(60)")
    private String name;

    @NotEmpty
    @Column(columnDefinition = "VARCHAR(10)")
    private String repRange;

    @NotEmpty
    @Column(columnDefinition = "VARCHAR(10)")
    private String breakRange;

    @OneToMany(mappedBy = "goal")
    private List<Workout> workout;

}
