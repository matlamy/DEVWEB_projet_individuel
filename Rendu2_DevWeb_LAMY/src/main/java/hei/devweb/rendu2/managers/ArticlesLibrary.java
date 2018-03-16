package hei.devweb.rendu2.managers;

import hei.devweb.rendu2.dao.ArticleDAO;
import hei.devweb.rendu2.dao.impl.ArticleDAOImpl;
import hei.devweb.rendu2.entities.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class ArticlesLibrary {

    private static class ArticlesLibraryHolder {
        private final static ArticlesLibrary instance = new ArticlesLibrary();}

    public static ArticlesLibrary getInstance() {
        return ArticlesLibraryHolder.instance;
    }

    private ArticleDAO articleDAO = new ArticleDAOImpl();

    private TreeMap<Integer, Article> articlesList;

    private ArticlesLibrary() {
        this.initialize();
    }

    public List<Article> listArticles() { return articleDAO.listeArticles();}

    public Article getArticle(Integer id) {return articleDAO.recupArticle(id);}


    public Article addArticle(Article article) {
       return articleDAO.ajoutArticle(article);
    }

    public void deleteArticle(Integer id) {articleDAO.supprArticle(id); }


    private void initialize() {

        articlesList = new TreeMap<>();
        articlesList.put(1, new Article(1, "Jupe","Dior", "Femme","120"));
        articlesList.put(2, new Article(2, "Manteau","Dior", "Homme","1420"));
        articlesList.put(3, new Article(3, "Haut","Dior", "Femme","12"));
        articlesList.put(4, new Article(4, "Pantalon","Sandro", "Homme","200"));
        articlesList.put(5, new Article(5, "Robe","Dior", "Femme","150"));}
}
