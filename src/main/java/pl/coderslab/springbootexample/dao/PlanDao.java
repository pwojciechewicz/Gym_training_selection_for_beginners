package pl.coderslab.springbootexample.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springbootexample.model.Plan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class PlanDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Plan> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Plan p");
        return query.getResultList();
    }

    public Plan findById(Long id) {
        return entityManager.find(Plan.class, id);
    }

}
