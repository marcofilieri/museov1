package it.linksmt.academy.museo;

import it.linksmt.academy.hibernate.core.museo.dao.implement.MuseoDAOImpl;
import it.linksmt.academy.hibernate.core.museo.dao.implement.SedeDAOImpl;
import it.linksmt.academy.hibernate.core.museo.dao.implement.UtenteDAOImpl;
import it.linksmt.academy.hibernate.core.museo.entity.Museo;
import it.linksmt.academy.hibernate.core.museo.entity.Sede;
import it.linksmt.academy.hibernate.core.museo.entity.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ModificaSedeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String idSede = req.getParameter("idSede");

        List<Long> ids = new ArrayList<Long>();
        ids.add(1L);
        ids.add(2L);

        Sede sedi = SedeDAOImpl.getInstance().getById(Long.valueOf(req.getParameter("idSede")));
        List<Utente> listaResponsabili = UtenteDAOImpl.getInstance().findByRuolo(ids);
        List<Museo> listaMusei = MuseoDAOImpl.getInstance().getAll();

        req.setAttribute("sede", sedi);
        req.setAttribute("listaResponsabili", listaResponsabili);
        req.setAttribute("listaMusei", listaMusei);

        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/view/modificaSede.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Sede sede = null;

        try {
            sede = new Sede();
            if (req.getParameter("idSede") != null && !req.getParameter("idSede").isEmpty()) {
                sede.setId(Long.valueOf(req.getParameter("idSede")));
            }

            if (req.getParameter("inputNome") != null && !req.getParameter("inputNome").isEmpty()) {
                sede.setNome(req.getParameter("inputNome"));
            }

            if (req.getParameter("inputDescrizione") != null && !req.getParameter("inputDescrizione").isEmpty()) {
                sede.setDescrizione(req.getParameter("inputDescrizione"));
            }

            if (req.getParameter("inputOrarioApertura") != null && !req.getParameter("inputOrarioApertura").isEmpty()) {
                sede.setOrarioApertura(new Time(new SimpleDateFormat("HH:mm").parse(req.getParameter("inputOrarioApertura")).getTime()));
            }

            if (req.getParameter("inputOrarioChiusura") != null && !req.getParameter("inputOrarioChiusura").isEmpty()) {
                sede.setOrarioChiusura(new Time(new SimpleDateFormat("HH:mm").parse(req.getParameter("inputOrarioChiusura")).getTime()));
            }

            if (req.getParameter("inputLatitudine") != null && !req.getParameter("inputLatitudine").isEmpty()) {
                sede.setLatitudine(Float.valueOf(req.getParameter("inputLatitudine")));
            } else {
                sede.setLatitudine(null);
            }

            if (req.getParameter("inputLongitudine") != null && !req.getParameter("inputLongitudine").isEmpty()) {
                sede.setLongitudine(Float.valueOf(req.getParameter("inputLongitudine")));
            } else {
                sede.setLongitudine(null);
            }

            if (req.getParameter("inputResponsabile") != null && !req.getParameter("inputResponsabile").isEmpty()) {
                Utente utente = new Utente();
                utente.setId(Long.valueOf(req.getParameter("inputResponsabile")));

                sede.setUtente(utente);
            } else {
                sede.setUtente(null);
            }

            if (req.getParameter("inputMuseo") != null && !req.getParameter("inputMuseo").isEmpty()) {
                Museo museo = new Museo();
                museo.setId(Long.valueOf(req.getParameter("inputMuseo")));

                sede.setMuseo(museo);
            } else {
                sede.setMuseo(null);
            }
            SedeDAOImpl.getInstance().update(sede);

        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
