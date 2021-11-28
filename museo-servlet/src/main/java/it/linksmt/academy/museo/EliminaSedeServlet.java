package it.linksmt.academy.museo;

import it.linksmt.academy.hibernate.core.museo.dao.implement.SedeDAOImpl;
import it.linksmt.academy.hibernate.core.museo.entity.Sede;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EliminaSedeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameter("idSede") != null && !req.getParameter("idSede").isEmpty()) {
                Sede sede = new Sede();
                sede.setId(Long.valueOf(req.getParameter("idSede")));
                SedeDAOImpl.getInstance().delete(sede);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/");
        dispatcher.forward(req, resp);
    }
}
