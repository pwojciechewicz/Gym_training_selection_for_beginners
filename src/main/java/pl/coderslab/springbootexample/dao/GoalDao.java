package pl.coderslab.springbootexample.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springbootexample.model.Goal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class GoalDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Goal> findAll() {
        Query query = entityManager.createQuery("SELECT g FROM Goal g");
        return query.getResultList();
    }

    public Goal findById(Long id) {
        return entityManager.find(Goal.class, id);
    }

}
