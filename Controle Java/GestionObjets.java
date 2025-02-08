import java.util.List;

public interface GestionObjets <T>{
    public void ajouter(T document);
    public List<T> rechercherParString(String titreDocument);
    public void afficherTousObjets();
    public void filtreInteger(int anneePublication);
    public void trierParInteger();
    public void afficherTousString();
} 