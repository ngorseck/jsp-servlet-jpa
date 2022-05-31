package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Categorie;
import sn.isi.entities.Produit;

public class CategorieImpl implements ICategorie {

	private EntityManager em;
	
	public CategorieImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("suiviStockPU");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(Categorie categorie) {
		try {
			em.getTransaction().begin();
			em.persist(categorie);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Categorie> getAll() {
		
		try {
			return em.createQuery("SELECT c FROM Categorie c").getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int update(Categorie categorie) {
		try {
			em.getTransaction().begin();
			em.merge(categorie);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(String ref) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Categorie.class, ref));
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Categorie get(String ref) {
		
		return em.find(Categorie.class, ref);
	}
}
