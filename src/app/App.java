package app;

public class App {
    public static void main(String[] args) throws Exception {

        ConnectionDB connect = new ConnectionDB();
        
        if(connect.openConnection()!=null){
            System.out.println("CONECTADO");
        }else{
            System.out.println("NO CONECTADO");
        }

    }
}