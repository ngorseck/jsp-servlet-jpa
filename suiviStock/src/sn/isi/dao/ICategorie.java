package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Categorie;

public interface ICategorie {
	public int add(Categorie categorie);
	public List<Categorie> getAll();
	public int update(Categorie categorie);
	public int delete(String ref);
	public Categorie get(String ref);
}
