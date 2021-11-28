package it.linksmt.academy.hibernate.core.museo.dao;

import it.linksmt.academy.hibernate.core.museo.entity.Utente;

import java.util.List;

public interface UtenteDAO {
    List<Utente> getAll();

    List<Utente> findByRuolo(List<Long> id);
}
