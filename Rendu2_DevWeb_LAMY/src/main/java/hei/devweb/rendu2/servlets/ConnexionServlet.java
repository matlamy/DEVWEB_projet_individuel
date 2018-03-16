package hei.devweb.rendu2.servlets;

import hei.devweb.rendu2.entities.Utilisateur;
import hei.devweb.rendu2.managers.UtilisateurLibrary;
import hei.devweb.rendu2.utils.MotDePasseUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/connexion")
public class ConnexionServlet extends GenericServlet{

    private Map<String, String> utilisateursAutorises;

    @Override
    public void init() throws ServletException {

        utilisateursAutorises = new HashMap<>();
        List< Utilisateur> listutil = UtilisateurLibrary.getInstance().listUtilisateur();
        for (Utilisateur util : listutil ) {
            utilisateursAutorises.put(util.getLogin(), util.getPassword());
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext webContext = new WebContext(req, resp, req.getServletContext());

        TemplateEngine templateEngine = this.createTemplateEngine(req);


        templateEngine.process("connexion", webContext, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identifiantFormulaire = req.getParameter("identifiant");
        String motDePasseFormulaire = req.getParameter("motdepasse");
        if (utilisateursAutorises.containsKey(identifiantFormulaire)) {
            if (utilisateursAutorises.get(identifiantFormulaire).equals(motDePasseFormulaire)) {
                req.getSession().setAttribute("utilisateurConnecte", identifiantFormulaire);
                resp.sendRedirect("home");
            } else {
                resp.sendRedirect("connexion");}
        } else {
            resp.sendRedirect("connexion");
        }
    }}