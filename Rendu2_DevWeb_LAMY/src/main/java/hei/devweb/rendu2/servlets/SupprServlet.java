package hei.devweb.rendu2.servlets;

import hei.devweb.rendu2.entities.Article;
import hei.devweb.rendu2.managers.ArticlesLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/delete")
public class SupprServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String articleId = req.getParameter("id");

        ArticlesLibrary.getInstance().deleteArticle(parseInt(articleId));

        resp.sendRedirect("listArticles");

    }
}
