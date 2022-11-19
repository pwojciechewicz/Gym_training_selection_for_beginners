package pl.coderslab.springbootexample.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springbootexample.model.Exercise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ExerciseDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Exercise> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM Exercise e");
        return query.getResultList();
    }
    public Exercise findById(Long id) {
        return entityManager.find(Exercise.class, id);
    }


}