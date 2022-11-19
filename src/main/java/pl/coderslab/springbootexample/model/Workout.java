package pl.coderslab.springbootexample.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "workouts")
@Getter
@Setter
@RequiredArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 60)
    @Column
    private String name;

    @ManyToOne
    private Plan plan;

    @ManyToOne
    private Goal goal;

    @ManyToOne
    private Unit unit;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.REMOVE)
    private List<WorkoutExercise> workoutsExercises;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Workout workout = (Workout) o;
        return id != null && Objects.equals(id, workout.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
