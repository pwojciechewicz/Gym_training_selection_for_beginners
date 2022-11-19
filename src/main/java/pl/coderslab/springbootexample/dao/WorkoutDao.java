package pl.coderslab.springbootexample.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springbootexample.model.Plan;
import pl.coderslab.springbootexample.model.Workout;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class WorkoutDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Workout> findAll() {
        Query query = entityManager.createQuery("SELECT w FROM Workout w");
        return query.getResultList();
    }

    public Workout findById(Long id) {
        return entityManager.find(Workout.class, id);
    }

    public void create(Workout workout) {
        entityManager.persist(workout);
    }

    public void remove(Workout workout) {
        entityManager.remove(entityManager.contains(workout) ? workout : entityManager.merge(workout));
    }

    public Workout update(Workout workout) {
        return entityManager.merge(workout);
    }


    public List<Workout> findAllWithPlan(){
        Query query = entityManager.createQuery("SELECT w FROM Workout w join w.plan");
        return query.getResultList();
    }
    public List<Workout> findByPlan(Plan plan) {
        Query query = entityManager.createQuery("SELECT w FROM Workout w join w.plan where w.plan=:plan");
        query.setParameter("plan", plan);
        return query.getResultList();
    }

}