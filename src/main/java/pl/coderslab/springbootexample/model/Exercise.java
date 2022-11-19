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
@Table(name = "exercises")
@Getter
@Setter
@RequiredArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(columnDefinition = "VARCHAR(100)")
    private String name;

    @NotEmpty
    @Column(columnDefinition = "VARCHAR(60)")
    private String bodyPart;

    @NotEmpty
    @Size(max = 600)
    @Column(columnDefinition = "LONGTEXT")
    private String link;

    @NotEmpty
    @Column(columnDefinition = "VARCHAR(10)")
    private String position;

    @OneToMany(mappedBy = "exercise")
    private List<WorkoutExercise> workoutsExercises;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Exercise exercise = (Exercise) o;
        return id != null && Objects.equals(id, exercise.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
