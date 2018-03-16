package hei.devweb.rendu2.webservices;

import hei.devweb.rendu2.entities.Article;
import hei.devweb.rendu2.managers.ArticlesLibrary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/total")
public class NombreArticlesWS {

    @GET
    public Response getNBnouveauxArticles(){
        List<Article> listNouveauxArticles = ArticlesLibrary.getInstance().listArticles();
        return Response.status(200).entity(listNouveauxArticles.size()).build();
    }
}
