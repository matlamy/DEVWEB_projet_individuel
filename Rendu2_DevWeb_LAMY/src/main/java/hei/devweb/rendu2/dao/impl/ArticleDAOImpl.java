package hei.devweb.rendu2.dao.impl;

import hei.devweb.rendu2.dao.ArticleDAO;
import hei.devweb.rendu2.entities.Article;

import javax.activation.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOImpl implements ArticleDAO {


    @Override
    public List<Article> listeArticles() {
        List<Article> listofArticles = new ArrayList<>();
        String query = "select * from articles" ;
        try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
            try (Statement statement = connection.createStatement()) {
                try (ResultSet results = statement.executeQuery(query)) {
                    while (results.next()) {
                        Article article = new Article(
                                results.getInt("article_id"),
                                results.getString("name"),
                                results.getString("brand"),
                                results.getString("gender"),
                                results.getString("price"));

                        listofArticles.add(article);
                    }             }         }     }
        catch (SQLException e) {

           e.printStackTrace();     }

           return listofArticles; }



    @Override
    public Article ajoutArticle(Article article) {
        String query = "insert into articles(name, brand, gender, price) " + "VALUES(?,?,?,?)";

        try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, article.getName());
                statement.setString(2, article.getBrand());
                statement.setString(3, article.getGender());
                statement.setString(4, article.getPrice());
                statement.executeUpdate();

                ResultSet ids = statement.getGeneratedKeys();
                if (ids.next()){
                    return new Article(ids.getInt(1), article.getName(), article.getBrand(), article.getGender(),article.getPrice());
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } return article ;
    }

    @Override
    public Article supprArticle(Integer id) {
                     try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "delete from articles where article_id=?")) {
                    statement.setInt(1,id);
                    statement.executeUpdate();
                }     }
            catch (SQLException e) {
                e.printStackTrace();
                     }

             return null ;}


    @Override
    public Article recupArticle(Integer id) {
        String query = "select * from articles where article_id=?";
        try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet results = preparedStatement.executeQuery()) {
                   if (results.next()) {
                        return new Article(
                                results.getInt("article_id"),
                                results.getString("name"),
                                results.getString("brand"),
                                results.getString("gender"),
                                results.getString("price"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

