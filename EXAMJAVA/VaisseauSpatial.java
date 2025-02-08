import java.util.HashMap;
import java.util.Map.Entry;

public class VaisseauSpatial {
    String nom;
    int pointVie;
    int pointEnergie;
    HashMap<String, Integer> lesAttaques=new HashMap<>();

    public VaisseauSpatial(String n , int pv , int pe ){
        this.nom=n;
        this.pointVie=pv;
        this.pointEnergie=pe;
        
    }

    public String getNom(){
        return nom;
    }
    public int getPointVie(){
        return pointVie;
    }
    public int getPointEnergis(){
        return pointEnergie;
    }

    public String toString(){
        return "le nom du vaisseau spatial :"+nom+" point de vie "+pointVie+ "point d'energie "+pointEnergie ;
    }

    public void ajouterAttaque(String n , int e ){
        lesAttaques.put(n,e);
    }

    public void afficherAttaques(int cout){
        System.out.println("les attaques dont le cout est inferieure à "+ cout);
        for ( Entry<String, Integer> attack : lesAttaques.entrySet()) {
            if(attack.getValue() < cout){
                System.out.println(attack.getKey());
            }
        } 
    }

    public void afficherAttaques(){
        System.out.println("les attaques de  vaisseau "+this.getNom()+" sont :");
        for ( Entry<String, Integer> attack : lesAttaques.entrySet()) {
            System.out.println(attack.getKey());
        } 
    }

    public void attaquer(VaisseauSpatial VaisseauSpatialCible , String nomAttaque) throws AttaqueInvalidException{
        
        if(!lesAttaques.containsKey(nomAttaque)){
                throw new AttaqueInvalidException("Attaque introuvable");
        }
        int coutEnergieAttaque=lesAttaques.get(nomAttaque);
        int pEnergie=this.getPointEnergis();
        
        pEnergie-=coutEnergieAttaque;
        this.pointEnergie=pEnergie;
        int pointVieCible=VaisseauSpatialCible.getPointVie();
        pointVieCible-=coutEnergieAttaque*2;
        VaisseauSpatialCible.pointVie=pointVieCible;
        System.out.println("les points de vie de "+VaisseauSpatialCible.getNom()+" est " + pointVieCible);
    }
    public void recharger(String nomAttaque){
        int pEnergie=this.getPointEnergis();
        int coutEnergieAttaque=lesAttaques.get(nomAttaque);
        if(pEnergie<coutEnergieAttaque){
            pEnergie+=10;
            this.pointEnergie=pEnergie;
            System.out.println("rechargé");
        }
    }
    
    public boolean estDetruit(){
        if(this.getPointVie()<=0) {return true;}
        return false;
        
    }

}
