public class Magazine extends Document{
    int frequencePublication;
    @Override
    public String getTypeDocument() {
        return "magazine";
    }
    public String toString(){
        String s=super.toString();
        return s + "frequence de publication : " + frequencePublication;
    }
    @Override
    protected Object compareTo(int anneePublication2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
