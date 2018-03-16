package hei.devweb.rendu2.managers;

import hei.devweb.rendu2.dao.UtilisateurDAO;
import hei.devweb.rendu2.dao.impl.UtilisateurDAOImpl;
import hei.devweb.rendu2.entities.Utilisateur;

import java.util.List;

public class UtilisateurLibrary {

    private static class UtilisateurLibraryHolder {
        private final static UtilisateurLibrary instance = new UtilisateurLibrary();}

    public static UtilisateurLibrary getInstance() {
        return UtilisateurLibrary.UtilisateurLibraryHolder.instance;
    }

    private UtilisateurDAO utilisateurDAO = new UtilisateurDAOImpl();

    public List<Utilisateur> listUtilisateur() {
        return utilisateurDAO.listeUtilisateurs();
    }

}
