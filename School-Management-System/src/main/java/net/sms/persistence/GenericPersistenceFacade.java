package net.sms.persistence;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gershom.Maluleke
 */
@Repository
@Transactional
public abstract class GenericPersistenceFacade<T extends Serializable> implements BaseDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    final Class<T> entityClass;
    
    public GenericPersistenceFacade(Class<T> entityClass){
        this.entityClass = entityClass;
    }
    
    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void save(T entity) {
       getCurrentSession().persist(entity);
    }

    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void update(T entity) {
       getCurrentSession().merge(entity);
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createQuery("from "+entityClass.getName()).list();
    }

    @Override
    public T find(Long id) {
      return getCurrentSession().get(entityClass, id);
    } 
}
