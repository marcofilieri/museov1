package it.linksmt.academy.hibernate.core.museo.dao.implement;

import it.linksmt.academy.hibernate.core.museo.dao.ArticoloDAO;
import it.linksmt.academy.hibernate.core.museo.dao.GenericDAO;
import it.linksmt.academy.hibernate.core.museo.dao.utility.HibernateUtil;
import it.linksmt.academy.hibernate.core.museo.entity.Articolo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ArticoloDAOImpl extends GenericDAO<Articolo> implements ArticoloDAO {

	private static ArticoloDAO instance;

	public static ArticoloDAO getInstance() {
		if (instance == null) {
			instance = new ArticoloDAOImpl();
		}
		return instance;
	}

	@Override
	public List<Articolo> getAll() {

		List<Articolo> articoli = new ArrayList<Articolo>();
		Transaction transaction = null;
		Session session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();
			Query query = session.createQuery("from articolo");
			articoli = query.list();
			session.getTransaction().commit();

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return articoli;

	}

	@Override
	public Articolo getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articolo save(Articolo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articolo update(Articolo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Articolo articolo) {

	}

}
