package hei.devweb.rendu2.dao;

import hei.devweb.rendu2.entities.Article;

import java.util.List;

public interface ArticleDAO {

    public List<Article> listeArticles() ;
    public Article ajoutArticle(Article article);
    public Article supprArticle(Integer id) ;
    public Article recupArticle(Integer id) ;

}
