package net.sms.persistence;

import java.util.List;

/**
 *
 * @author Gershom.Maluleke
 * 
 */

public interface BaseDAO<T> {

    public Long save(T entity);

    public void delete(T entity);

    public void update(T entity);

    public List<T> findAll();

    public T find(Long id);
}
