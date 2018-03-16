package hei.devweb.rendu2.dao.impl;

import hei.devweb.rendu2.dao.UtilisateurDAO;
import hei.devweb.rendu2.entities.Article;
import hei.devweb.rendu2.entities.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAOImpl implements UtilisateurDAO{

    @Override
    public List<Utilisateur> listeUtilisateurs() {
        List<Utilisateur> listofUtilisateurs = new ArrayList<>();
            String query = "select * from utilisateurs" ;
            try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
                try (Statement statement = connection.createStatement()) {
                    try (ResultSet results = statement.executeQuery(query)) {
                        while (results.next()) {
                           Utilisateur utilisateur = new Utilisateur(
                                    results.getInt("utilisateur_id"),
                                    results.getString("login"),
                                    results.getString("password"));

                            listofUtilisateurs.add(utilisateur);
                        }             }         }     }
            catch (SQLException e) {

                e.printStackTrace();     }

            return listofUtilisateurs;
    }


    @Override
    public Utilisateur ajoutUtilisateur(Utilisateur utilisateur) {
        String query = "insert into utilisateurs(login, password) " + "VALUES(?,?)";
        try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, utilisateur.getLogin());
                statement.setString(2, utilisateur.getPassword());
                statement.executeUpdate();

                ResultSet ids = statement.getGeneratedKeys();
                if (ids.next()){
                    return new Utilisateur(ids.getInt(1), utilisateur.getLogin(), utilisateur.getPassword());
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } return utilisateur ;
    }
    }

