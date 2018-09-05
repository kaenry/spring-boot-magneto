package org.master.common;

import java.util.List;
import java.util.Optional;

/**
 * Created by kaenry on 2016/6/17.
 * ICommonService
 * common interface
 */
public interface ICommonService<T> {
    T save(T entity) throws Exception;
    void delete(Long id) throws Exception;
    Optional<T> findById(Long id);
    Iterable<T> findAll();
}
