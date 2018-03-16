package hei.devweb.rendu2.dao;

import hei.devweb.rendu2.entities.Article;
import hei.devweb.rendu2.entities.Utilisateur;

import java.util.List;

public interface UtilisateurDAO {

    public List<Utilisateur> listeUtilisateurs() ;
    public Utilisateur ajoutUtilisateur(Utilisateur utilisateur);
}
