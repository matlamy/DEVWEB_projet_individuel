package hei.devweb.rendu2.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public abstract class GenericServlet extends HttpServlet {

    protected TemplateEngine createTemplateEngine(HttpServletRequest request) {

        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(request.getServletContext());

        templateResolver.setPrefix("/WEB-INF/templates/");

        templateResolver.setSuffix(".html");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);


        return templateEngine;
    }
}

