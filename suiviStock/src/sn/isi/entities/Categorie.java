package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categorie implements Serializable {
	
	@Id
	private String ref;
	@Column(length=150)
	private String nom;
	@ManyToOne
	private User id = new User();
	@OneToMany(mappedBy = "categorie")
	private List<Produit> produits = new ArrayList<Produit>();
	
	public Categorie() {
		super();
	}
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public User getId() {
		return id;
	}
	public void setId(User id) {
		this.id = id;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	public String toString() {
		return nom;
	}
	
}
