import hei.devweb.rendu2.dao.impl.ArticleDAOImpl;
import hei.devweb.rendu2.entities.Article;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.sql.Statement;
import java.util.List;

public class ArticlesDAOTestCase  extends  ArticleAbstractDAOTestCase{

    ArticleDAOImpl articlesDAO = new ArticleDAOImpl();

       @Override
    public void insertDataSet(Statement statement) throws Exception {
           statement.executeUpdate("INSERT INTO articles (name,brand,gender,price) VALUES ('Article 1','Marque 1','Genre 1','Price 1');");
           statement.executeUpdate("INSERT INTO articles (name,brand,gender,price) VALUES ('Article 2','Marque 2','Genre 2','Price 2');");

       }

       @Test
    public void shouldListArticles() throws  Exception{
           //WHEN
           List<Article> articles =articlesDAO.listeArticles();

           Assertions.assertThat(articles).hasSize(2);
           Assertions.assertThat(articles).extracting("name","brand","gender","price").containsOnly(
                           Assertions.tuple("Article 1","Marque 1","Genre 1","Price 1"),
                           Assertions.tuple("Article 2","Marque 2","Genre 2","Price 2"));

       }



       }

