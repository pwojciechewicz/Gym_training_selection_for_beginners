package pl.coderslab.springbootexample.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springbootexample.model.Workout;
import pl.coderslab.springbootexample.model.WorkoutExercise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class WorkoutExerciseDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<WorkoutExercise> findAll() {
        Query query = entityManager.createQuery("SELECT we FROM WorkoutExercise we");
        return query.getResultList();
    }

    public WorkoutExercise findById(Long id) {
        return entityManager.find(WorkoutExercise.class, id);
    }

    public void create(WorkoutExercise workoutExercise) {
        entityManager.persist(workoutExercise);
    }

    public void remove(WorkoutExercise workoutExercise) {
        entityManager.remove(entityManager.contains(workoutExercise) ? workoutExercise : entityManager.merge(workoutExercise));
    }

    public WorkoutExercise update(WorkoutExercise workoutExercise) {
        return entityManager.merge(workoutExercise);
    }

    public List<WorkoutExercise> findByWorkout(Workout workout) {
        Query query = entityManager.createQuery("SELECT we FROM WorkoutExercise we join we.workout where we.workout=:workout");
        query.setParameter("workout", workout);
        return query.getResultList();
    }

}