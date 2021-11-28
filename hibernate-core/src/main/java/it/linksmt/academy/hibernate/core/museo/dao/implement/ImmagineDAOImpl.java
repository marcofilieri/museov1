package it.linksmt.academy.hibernate.core.museo.dao.implement;

import it.linksmt.academy.hibernate.core.museo.dao.GenericDAO;
import it.linksmt.academy.hibernate.core.museo.dao.ImmagineDAO;
import it.linksmt.academy.hibernate.core.museo.dao.utility.HibernateUtil;
import it.linksmt.academy.hibernate.core.museo.entity.Immagine;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ImmagineDAOImpl extends GenericDAO<Immagine> implements ImmagineDAO {

    private static ImmagineDAO instance;

    public static ImmagineDAO getInstance() {
        if (instance == null) {
            instance = new ImmagineDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Immagine> getAll() {

        List<Immagine> immagini = new ArrayList<Immagine>();
        Transaction transaction = null;
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();
            Query query = session.createQuery("from Immagine");
            immagini = query.list();
            session.getTransaction().commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return immagini;

    }

    @Override
    public Immagine getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Immagine save(Immagine t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Immagine update(Immagine t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Immagine immagine) {

    }

}
