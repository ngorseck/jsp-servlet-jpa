package sn.isi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.CategorieImpl;
import sn.isi.dao.ICategorie;
import sn.isi.dao.IProduit;
import sn.isi.dao.ProduitImpl;
import sn.isi.entities.Categorie;
import sn.isi.entities.Produit;
import sn.isi.entities.User;

@WebServlet(name = "produit", value = "/Produit")
public class ProduitServlet extends HttpServlet {

	private IProduit produitdao;
	private ICategorie categoriedao;
	public ProduitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		produitdao = new ProduitImpl();
		categoriedao = new CategorieImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("usersession") == null) {
			resp.sendRedirect("Login");
		} else {
		
			List<Produit> produits = produitdao.getAll();
			req.setAttribute("list_produits", produits);
			
			List<Categorie> categories = categoriedao.getAll();
			req.setAttribute("list_categories", categories);
			req.getRequestDispatcher("WEB-INF/produits/list.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ref = req.getParameter("ref").toString();
		String nom = req.getParameter("nom").toString();
		double qt = Double.parseDouble(req.getParameter("qt").toString());
		String idCategorie = req.getParameter("categorie").toString();
		Categorie categorie = categoriedao.get(idCategorie);
		User user = (User)req.getSession().getAttribute("usersession");
		
		Produit produit = new Produit();
		produit.setRef(ref);
		produit.setNom(nom);
		produit.setQtStock(qt);
		produit.setCategorie(categorie);
		produit.setId(user);
		
		
		produitdao.add(produit);
		resp.sendRedirect("Produit");
	}
}
