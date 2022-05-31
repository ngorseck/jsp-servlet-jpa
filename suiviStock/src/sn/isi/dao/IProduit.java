package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Produit;

public interface IProduit {

	public int add(Produit produit);
	public List<Produit> getAll();
	public int update(Produit produit);
	public int delete(String ref);
	public Produit get(String ref);
}
