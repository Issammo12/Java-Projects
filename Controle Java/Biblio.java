import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Biblio implements GestionObjets<Document> {
    Set<Document> set= new HashSet<Document>();
    Map<Client , List<Document>> map= new HashMap<>();
    public void ajouter(Document document){
        set.add(document);
    }
    public List<Document> rechercherParString(String titreDocument){
        List<Document> list = new ArrayList<>();
        for(Document m : set){
            if(m.title == titreDocument ){
                list.add(m);
            }
        }
        return list;
    }
    public void afficherTousObjets(){
        Iterator<Document> iterator = set.iterator();
        System.out.println(iterator.next());
    }
    public void filtreInteger(int anneePublication){
        List<Document> listFiltre=set.stream().filter(doc->doc.anneePublication>anneePublication).collect(Collectors.toList());
        System.out.println(listFiltre);
    }

    public void trierParInteger(){
        List<Document> sorted=set.stream().sorted(Comparator.comparingInt(doc-> doc.anneePublication)).collect(Collectors.toList());
        System.out.println(sorted);
    }
    public void afficherTousString(){
        for(Document m :set){
            System.out.println(m.title);
        }
    }

    public void ajouterClients(Client c){
        map.put(c, null);
    }
    public void afficherClients(){
        for(Client c : map.keySet()){
            System.out.println("Client : " + c) ;
            
        }
    }
    public void documentAncien(){
        int max = 0;
        for(Document d : set ){
            if(d.anneePublication>=max){
                max = d.anneePublication;
            }
        }
        System.out.println("le document le plus ancien est ecrit dans :" + max);
    }

    public void ajouDocumentsFich(Path lienFich) throws FileNotFoundException{
        File file = lienFich.toFile();
        PrintWriter writer = new PrintWriter(file);
        for(Document d : set ){
            writer.println(d.toString());
        }
        writer.close();
    }
    public void publicConsultClient(){
        int documentConsultes=map.get(this).size();
        List<Document> doc=map.get(this);
        int cptLivre=0;
        int cptMagazine=0;
        for(Document d : doc){
            String ge = d.getTypeDocument();
            if(ge=="livre"){
                cptLivre++;
            }
            if(ge=="magazine"){
                cptMagazine++;
            }
        }
        System.out.println("le nombre de documents consultés est : " + documentConsultes);
        if (cptLivre>cptMagazine) {
            System.out.println("ce client consulte les livres");
        }else{
            System.out.println("ce client consulte les magazines");
        }
    }

    public void activeClient(){
        Optional<Map.Entry<Client , List<Document>>> e= map.entrySet().stream().max(Comparator.comparingInt(value -> value.getValue().size()));
        e.ifPresent(value-> {
            System.out.println("le client le plus active est : " + value.getKey().toString());
        });
    }
    public void serialisationMap() throws FileNotFoundException, IOException{
        ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream("Map.ser"));
        ser.writeObject(map);
        System.out.println("la serialisation est effectuée");
    }
}

