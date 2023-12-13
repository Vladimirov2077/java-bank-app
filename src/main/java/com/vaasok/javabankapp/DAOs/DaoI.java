package com.vaasok.javabankapp.DAOs;

import java.util.List;

public interface DaoI<T> {
    T save(T obj);
    boolean delete(T obj);
    void deleteAll(List<T> entities);
    void saveAll(List<T> entities);
    List<T> findAll();
    boolean deleteById(long id);
    T findById(long id);

}
