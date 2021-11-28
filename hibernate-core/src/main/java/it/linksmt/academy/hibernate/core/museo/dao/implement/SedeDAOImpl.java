package it.linksmt.academy.hibernate.core.museo.dao.implement;

import it.linksmt.academy.hibernate.core.museo.dao.GenericDAO;
import it.linksmt.academy.hibernate.core.museo.dao.SedeDAO;
import it.linksmt.academy.hibernate.core.museo.dao.utility.HibernateUtil;
import it.linksmt.academy.hibernate.core.museo.entity.Sede;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class SedeDAOImpl extends GenericDAO<Sede> implements SedeDAO {

    private static SedeDAO instance;

    public static SedeDAO getInstance() {
        if (instance == null) {
            instance = new SedeDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Sede> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Sede> listaSedi = null;

        try {
            session.beginTransaction();
            listaSedi = session.createQuery("from Sede", Sede.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        return listaSedi;
    }

    @Override
    public Sede getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Sede> listaSedi = null;
        Sede sede = null;

        try {
            session.beginTransaction();
            listaSedi = session.createQuery("from Sede where id= :id", Sede.class).setParameter("id", id).list();
            sede = listaSedi.get(0);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sede;
    }

    @Override
    public Sede save(Sede sede) {
        return null;
    }

    @Override
    public Sede update(Sede sede) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();

            Query query = session.createQuery("update Sede set descrizione= :descrizione, dataModifica= :dataModifica, orarioApertura= :orarioApertura, orarioChiusura= :orarioChiusura, latitudine= :latitudine, longitudine= :longitudine, utente= :utente, museo= :museo where id= :id");
            query.setParameter("id", sede.getId());
            query.setParameter("descrizione", sede.getDescrizione());
            query.setParameter("dataModifica", new Date());
            query.setParameter("orarioApertura", sede.getOrarioApertura());
            query.setParameter("orarioChiusura", sede.getOrarioChiusura());
            query.setParameter("latitudine", sede.getLatitudine());
            query.setParameter("longitudine", sede.getLongitudine());
            query.setParameter("utente", sede.getUtente());
            query.setParameter("museo", sede.getMuseo());

            query.executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return getById(sede.getId());
    }

    @Override
    public void delete(Sede input) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(input);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }


//	public static void main(String[] args) {
//			Sede edited = new Sede();
//			edited.setId(9L);
//			edited.setDescrizione("Edited using DAO");
//			Sede sede = new SedeDAOImpl().update(edited);
//			try {
//				System.out.println(sede);
//			}catch (Exception e) {}
//
//
//	}
}
