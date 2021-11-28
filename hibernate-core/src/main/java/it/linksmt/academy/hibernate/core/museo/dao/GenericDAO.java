package it.linksmt.academy.hibernate.core.museo.dao;

import java.util.List;

public abstract class GenericDAO<T> {
    public abstract List<T> getAll();

    public abstract T getById(Long id);

    public abstract T save(T t);

    public abstract T update(T t);

    public abstract void delete(T t);
}
