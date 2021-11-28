package it.linksmt.academy.museo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.linksmt.academy.hibernate.core.museo.dao.implement.SedeDAOImpl;
import it.linksmt.academy.hibernate.core.museo.entity.Sede;

public class ListaSediServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaSediServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			List<Sede> listaSedi = SedeDAOImpl.getInstance().getAll();
			request.setAttribute("listaSedi", listaSedi);
		} catch (Exception e) {
			System.out.println("ListaSediServlet Error :: [" + e.getMessage() + "]");
			request.setAttribute("errorMessage",
					"Impossibile recuperare la lista delle sedi. Si prega di riprovare più tardi.");
		}

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/listaSedi.jsp");
		dispatcher.forward(request, response);

	}
}
