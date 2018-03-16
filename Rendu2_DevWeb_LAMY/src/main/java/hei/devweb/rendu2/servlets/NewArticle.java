package hei.devweb.rendu2.servlets;

import hei.devweb.rendu2.entities.Article;
import hei.devweb.rendu2.managers.ArticlesLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newArticle")
public class NewArticle extends GenericServlet {


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            WebContext webContext = new WebContext(req, resp, req.getServletContext());


            TemplateEngine templateEngine = this.createTemplateEngine(req);
                templateEngine.process("newArticle", webContext, resp.getWriter());
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // GET PARAMETERS
            String name = req.getParameter("name");
            String brand = req.getParameter("brand") ;
            String price = req.getParameter("price");
            String gender = req.getParameter("gender");



           Article newArticle = new Article(null, name, brand, gender, price);
           Article createdArticle = ArticlesLibrary.getInstance().addArticle(newArticle);


            resp.sendRedirect(String.format("article?id=%s", createdArticle.getId()));
        }
    }


