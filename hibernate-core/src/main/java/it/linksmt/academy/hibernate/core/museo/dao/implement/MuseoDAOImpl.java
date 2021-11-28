package it.linksmt.academy.hibernate.core.museo.dao.implement;

import it.linksmt.academy.hibernate.core.museo.dao.GenericDAO;
import it.linksmt.academy.hibernate.core.museo.dao.MuseoDAO;
import it.linksmt.academy.hibernate.core.museo.dao.utility.HibernateUtil;
import it.linksmt.academy.hibernate.core.museo.entity.Museo;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class MuseoDAOImpl extends GenericDAO<Museo> implements MuseoDAO {
    private static MuseoDAO instance;

    public static MuseoDAO getInstance() {
        if (instance == null) {
            instance = new MuseoDAOImpl();
        }
        return instance;
    }

    public List<Museo> getAll() {
        List<Museo> listaMusei = new ArrayList<Museo>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            listaMusei = session.createQuery("from Museo", Museo.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        return listaMusei;
    }

    public Museo getById(Long id) {
        return null;
    }

    public Museo save(Museo museo) {
        return null;
    }

    public Museo update(Museo museo) {
        return null;
    }

    @Override
    public void delete(Museo museo) {
        
    }

}
