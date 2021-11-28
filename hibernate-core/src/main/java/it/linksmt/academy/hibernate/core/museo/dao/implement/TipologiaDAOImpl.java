package it.linksmt.academy.hibernate.core.museo.dao.implement;

import it.linksmt.academy.hibernate.core.museo.dao.GenericDAO;
import it.linksmt.academy.hibernate.core.museo.dao.TipologiaDAO;
import it.linksmt.academy.hibernate.core.museo.dao.utility.HibernateUtil;
import it.linksmt.academy.hibernate.core.museo.entity.Tipologia;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TipologiaDAOImpl extends GenericDAO<Tipologia> implements TipologiaDAO {

    private static TipologiaDAO instance;

    public static TipologiaDAO getInstance() {
        if (instance == null) {
            instance = new TipologiaDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Tipologia> getAll() {

        List<Tipologia> tipologie = new ArrayList<Tipologia>();
        Transaction transaction = null;
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();
            Query query = session.createQuery("from articolo");
            tipologie = query.list();
            session.getTransaction().commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return tipologie;

    }

    public Tipologia getById(Long id) {
        return null;
    }

    public Tipologia save(Tipologia tipologia) {
        return null;
    }

    public Tipologia update(Tipologia tipologia) {
        return null;
    }

    @Override
    public void delete(Tipologia tipologia) {

    }

}
