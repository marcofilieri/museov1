package it.linksmt.academy.hibernate.core.museo.dao.implement;

import it.linksmt.academy.hibernate.core.museo.dao.GenericDAO;
import it.linksmt.academy.hibernate.core.museo.dao.PreferitoDAO;
import it.linksmt.academy.hibernate.core.museo.dao.utility.HibernateUtil;
import it.linksmt.academy.hibernate.core.museo.entity.Preferito;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PreferitoDAOImpl extends GenericDAO<Preferito> implements PreferitoDAO {
    private static PreferitoDAO instance;

    public static PreferitoDAO getInstance() {
        if (instance == null) {
            instance = new PreferitoDAOImpl();
        }
        return instance;
    }

    public List<Preferito> getAll() {

        List<Preferito> preferiti = new ArrayList<Preferito>();
        Transaction transaction = null;
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();
            Query query = session.createQuery("from preferito");
            preferiti = query.list();
            session.getTransaction().commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return preferiti;

    }

    public Preferito getById(Long id) {
        return null;
    }

    public Preferito save(Preferito preferito) {
        return null;
    }

    public Preferito update(Preferito preferito) {
        return null;
    }

    @Override
    public void delete(Preferito preferito) {
        
    }

}
