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
import sn.isi.entities.Categorie;
import sn.isi.entities.Produit;
import sn.isi.entities.User;

/**
 * Servlet implementation class CategorieServlet
 */
@WebServlet("/Categorie")
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ICategorie categoriedao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		categoriedao = new CategorieImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usersession") == null) {
			response.sendRedirect("Login");
		} else {
		
			List<Categorie> categories = categoriedao.getAll();
			request.setAttribute("list_categories", categories);
			request.getRequestDispatcher("WEB-INF/categorie/list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref = request.getParameter("ref").toString();
		String nom = request.getParameter("nom").toString();
		
		Categorie categorie = new Categorie();
		categorie.setRef(ref);
		categorie.setNom(nom);
		User user = (User)request.getSession().getAttribute("usersession");
		categorie.setId(user);
		
		categoriedao.add(categorie);
		response.sendRedirect("Categorie");
	}

}
