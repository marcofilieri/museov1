package it.linksmt.academy.hibernate.core.museo.dao;

import it.linksmt.academy.hibernate.core.museo.entity.Museo;

import java.util.List;

public interface MuseoDAO {
    List<Museo> getAll();
}
