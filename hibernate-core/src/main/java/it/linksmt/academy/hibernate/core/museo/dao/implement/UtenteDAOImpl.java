package it.linksmt.academy.hibernate.core.museo.dao.implement;

import it.linksmt.academy.hibernate.core.museo.dao.GenericDAO;
import it.linksmt.academy.hibernate.core.museo.dao.UtenteDAO;
import it.linksmt.academy.hibernate.core.museo.dao.utility.HibernateUtil;
import it.linksmt.academy.hibernate.core.museo.entity.Utente;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UtenteDAOImpl extends GenericDAO<Utente> implements UtenteDAO {

    private static UtenteDAO instance;

    public static UtenteDAO getInstance() {
        if (instance == null) {
            instance = new UtenteDAOImpl();
        }
        return instance;
    }

    public List<Utente> getAll() {

        List<Utente> listaUtenti = new ArrayList<Utente>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            listaUtenti = session.createQuery("from Utente", Utente.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        return listaUtenti;
    }

    @Override
    public List<Utente> findByRuolo(List<Long> id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Utente> utentiFiltered = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Utente where ruolo.id in(:id)", Utente.class);

            query.setParameter("id", id);
            utentiFiltered = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return utentiFiltered;
    }

    public Utente getById(Long id) {
        return null;
    }

    public Utente save(Utente utente) {
        return null;
    }

    public Utente update(Utente utente) {
        return null;
    }

    @Override
    public void delete(Utente utente) {
        
    }

}
