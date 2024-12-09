package br.com.blz.testjava.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    T create(T entity);
    Optional<T> findById(ID id);
    void deleteById(ID id);
    List<T> findAll();
}
