package org.master.common;

import java.util.List;

/**
 * T entity type
 * E primary id key type
 * @author kevinzou
 * @date 2018/9/6
 * ICommonDao
 */
public interface ICommonDao<T, E> {
    /**
     * save
     * @param entity
     * @return
     * @throws Exception
     */
    void save(T entity) throws Exception;

    /**
     * delete by id
     * @param id
     * @throws Exception
     */
    void delete(E id) throws Exception;

    /**
     * modify
     * @param entity
     * @return
     * @throws Exception
     */
    void update (T entity) throws Exception;

    /**
     * find by id
     * @param id
     * @return
     */
    T findById(E id);

    /**
     * find all
     * @return
     */
    List<T> findAll();

}
