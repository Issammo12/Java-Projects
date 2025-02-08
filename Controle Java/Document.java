public abstract class Document {
    protected int id;
    protected String title;
     protected String auteur;
     protected int anneePublication;
    public String toString(){
        return "le document " + title + "id : " +id + "est écrit par :" + auteur + "en : "+ anneePublication;
    }
    public abstract String getTypeDocument();
    protected abstract Object compareTo(int anneePublication2);
}
