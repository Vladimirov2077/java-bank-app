package com.vaasok.javabankapp.DAOs;

import java.util.List;

public interface DaoI<T> {
    T save(T obj);
    boolean delete(T obj);
    void deleteAll(List<T> entities);
    void saveAll(List<T> entities);
    List<T> findAll();
    boolean deleteById(Long id);
    T findById(Long id);

}
