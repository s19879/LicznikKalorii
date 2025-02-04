package priv.calloriescounter.indirect.repositories;

import java.util.List;

public interface ICrudRepository<T, ID>{

    List<T> findAll();
    T findById(ID id);
    List<T> findAllByField(String fieldName, String value);
    T findByFieldName(String fieldName, String value);
    T save(T saveObject);
    boolean deleteById(ID id);
    boolean deleteByFieldName(String fieldName, String name);
    boolean delete(T entity);
    boolean existById(ID id);
    boolean existByName(String fieldName, String name);
}
