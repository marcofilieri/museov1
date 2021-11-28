package it.linksmt.academy.hibernate.core.museo.dao;

import java.util.List;

import it.linksmt.academy.hibernate.core.museo.entity.Articolo;

public interface ArticoloDAO {
	List<Articolo> getAll();
}
