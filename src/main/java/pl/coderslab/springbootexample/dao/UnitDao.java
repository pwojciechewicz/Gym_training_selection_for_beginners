package pl.coderslab.springbootexample.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springbootexample.model.Unit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UnitDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Unit> findAll() {
        Query query = entityManager.createQuery("SELECT u FROM Unit u");
        return query.getResultList();
    }

    public Unit findById(Long id) {
        return entityManager.find(Unit.class, id);
    }
}