package pl.coderslab.springbootexample.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "units")
@Data
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private Integer unitsPerWeek;

    @NotEmpty
    @Column(columnDefinition = "VARCHAR(10)")
    private String setRange;

    @OneToMany(mappedBy = "unit")
    private List<Workout> workout;

}
