import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VaisseauSpatial a=new VaisseauSpatial("a", 50, 50);
        VaisseauSpatial b=new VaisseauSpatial("b", 50, 50);
        System.out.println("ajout les attaques du vaisseau "+a.getNom());
        a.ajouterAttaque("attaque foudre" , 10);
        a.ajouterAttaque("attaque feu" , 20);
        a.ajouterAttaque("attaque eau" , 30);
        System.out.println("ajout les attaques du vaisseau "+b.getNom());
        b.ajouterAttaque("attaque terre" , 10);
        b.ajouterAttaque("attaque lumiere" , 40);
        b.ajouterAttaque("attaque neige" , 5);
        int pViea=a.getPointVie();
        int pVieb=b.getPointVie();
        int tour=1;
        while (a.estDetruit() || b.estDetruit()) {
            System.out.println("**************tour"+ tour++ +"************");
         try {
            a.afficherAttaques();
            Scanner scana = new Scanner(System.in);
            System.out.println("choisir l'attaque:");
            String attacka=scana.nextLine();
            b.afficherAttaques();
            Scanner scanb = new Scanner(System.in);
            System.out.println("choisir l'attaque:");
            String attackb=scanb.nextLine();
            // a.recharger(attacka);
            // b.recharger(attackb);
            a.attaquer(b, attacka);
            b.attaquer(a, attackb);
         } catch (AttaqueInvalidException e) {
            e.getMessage();
         }
        }
        
        
    }
}