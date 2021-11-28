package it.linksmt.academy.hibernate.core.museo.dao.implement;

import it.linksmt.academy.hibernate.core.museo.dao.GenericDAO;
import it.linksmt.academy.hibernate.core.museo.dao.RuoloDAO;
import it.linksmt.academy.hibernate.core.museo.dao.utility.HibernateUtil;
import it.linksmt.academy.hibernate.core.museo.entity.Ruolo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RuoloDAOImpl extends GenericDAO<Ruolo> implements RuoloDAO {

    private static RuoloDAO instance;

    public static RuoloDAO getInstance() {
        if (instance == null) {
            instance = new RuoloDAOImpl();
        }
        return instance;
    }

    public List<Ruolo> getAll() {

        List<Ruolo> ruoli = new ArrayList<Ruolo>();
        Transaction transaction = null;
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();
            Query query = session.createQuery("from ruolo");
            ruoli = query.list();
            session.getTransaction().commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return ruoli;

    }

    public Ruolo getById(Long id) {
        return null;
    }

    public Ruolo save(Ruolo ruolo) {
        return null;
    }

    public Ruolo update(Ruolo ruolo) {
        return null;
    }

    @Override
    public void delete(Ruolo ruolo) {
        
    }

}
