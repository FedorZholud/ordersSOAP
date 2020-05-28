package repository;

import entity.JpaBaseEntity;
import repository.JpaRepository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Fedor Zholud
 *
 */

public abstract class AbstractJpaRepository<T extends JpaBaseEntity> implements JpaRepository<T> {

    private Class<T> entityClass;

    public AbstractJpaRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext(name = "myUnit")
    private EntityManager em;

    @Override
    public void create(T entity) {
        em.persist(entity);
    }

    @Override
    public T find(long id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll(int page, int pageSize) {
        int firstResult = (page - 1) * pageSize;
        TypedQuery<T> query = em.createNamedQuery(entityClass.getName() + ".findAll", entityClass)
                .setFirstResult(firstResult)
                .setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public List<T> findAll(long param, int page, int pageSize) {
        int firstResult = (page - 1) * pageSize;
        TypedQuery<T> query = em.createNamedQuery(entityClass.getName() + ".findAll", entityClass)
                .setParameter("param", param)
                .setFirstResult(firstResult)
                .setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }
}
