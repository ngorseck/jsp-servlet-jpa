package sn.isi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produit implements Serializable {

	@Id
	private String ref;
	@Column(length=150)
	private String nom;
	@Column
	private double qtStock;
	@ManyToOne
	private User id = new User();
	@ManyToOne
	private Categorie categorie = new Categorie();
	
	public Produit() {
		super();
	}


	public Produit(String ref, String nom, double qtStock, User id) {
		super();
		this.ref = ref;
		this.nom = nom;
		this.qtStock = qtStock;
		this.id = id;
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


	public double getQtStock() {
		return qtStock;
	}


	public void setQtStock(double qtStock) {
		this.qtStock = qtStock;
	}


	public User getId() {
		return id;
	}


	public void setId(User id) {
		this.id = id;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
		
}
