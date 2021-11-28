package it.linksmt.academy.hibernate.core.museo.dao;

import it.linksmt.academy.hibernate.core.museo.entity.Sede;

import java.util.List;

public interface SedeDAO {
    List<Sede> getAll();

    Sede update(Sede sede);

    Sede getById(Long id);

    void delete(Sede input);
}
