public class Client {
    int id;
    String name;
    String email;
    public void equals(Client e){
        if(this.id==e.id && this.name==e.name && this.email==e.email){
            System.out.println("les deux clients sont les mémes");
        }
    }
    public void HashCode(){
        
    }
}
