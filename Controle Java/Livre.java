public class Livre extends Document {
    int nbrePages ;
    Genre genre;
    @Override
    public String getTypeDocument() {
        return "livre";
    }
    public String toString(){
        String s=super.toString();
        return s + "nombre de pages : "+ nbrePages + " de genre : "+genre;
    }
    @Override
    protected Object compareTo(int anneePublication2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
