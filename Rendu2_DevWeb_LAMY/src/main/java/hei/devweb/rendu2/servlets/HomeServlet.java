package hei.devweb.rendu2.servlets;

import hei.devweb.rendu2.entities.Article;
import hei.devweb.rendu2.managers.ArticlesLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext webContext = new WebContext(req, resp, req.getServletContext());

        TemplateEngine templateEngine = this.createTemplateEngine(req);

        List<Article> listOfArticles = ArticlesLibrary.getInstance().listArticles();
        webContext.setVariable("articlesList", listOfArticles);

        templateEngine.process("home", webContext, resp.getWriter());

    }
}

