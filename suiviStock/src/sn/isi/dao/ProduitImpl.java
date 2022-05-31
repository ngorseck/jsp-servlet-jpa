package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Produit;

public class ProduitImpl implements IProduit {

	private EntityManager em;
	
	public ProduitImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("suiviStockPU");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(Produit produit) {
		try {
			em.getTransaction().begin();
			em.persist(produit);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Produit> getAll() {
		
		try {
			return em.createQuery("SELECT p FROM Produit p").getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int update(Produit produit) {
		try {
			em.getTransaction().begin();
			em.merge(produit);
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
			em.remove(em.find(Produit.class, ref));
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Produit get(String ref) {
		
		return em.find(Produit.class, ref);
	}

}
