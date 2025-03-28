package controller;
import java.util.Scanner;

public class clServers {

    public String serverOrigen;
    public String serverDestiono;
    public String userOrigen;
    public String userDestino;
    public String passwordOrigen;
    public String passwordDestino;
    private Scanner teclado = new Scanner(System.in);
    private String mtdMuestraServidores(){
        System.out.println("+++++++Servidor++++++++");
        System.out.println("1) Medellin");
        System.out.println("2) Nacional");
        System.out.println("3) Calidad");
        System.out.println("4) Desarrollo");
        System.out.println("5) Otro");
        System.out.println("++++++++++++++++++++++++");
        System.out.println("Server:");
        String opServidor = teclado.nextLine();
        return mtdValidaServidores(opServidor);
    }

    private String mtdValidaServidores(String op){
        String server = null;
        switch (op){
            case "1":
                server = "10.9.3.101";
                break;
            case "2":
                server = "10.9.2.201";
                break;
            case "3":
                server = "10.9.2.221";
                break;
            case "4":
                server = "10.9.2.121";
                break;
            default:
                System.out.println("IP Server:");
                server = teclado.nextLine();
        }
        return server;
    }

    public void mtdSolicitarInformacionServidores(){
        System.out.println("----------------------------------------");
        System.out.println("Ingrese información servidor origen:");
        this.serverOrigen = this.mtdMuestraServidores();
        System.out.println("user:");
        this.userOrigen = teclado.nextLine();
        System.out.println("password:");
        this.passwordOrigen = teclado.nextLine();
        System.out.println("----------------------------------------");
        System.out.println("Ingrese información servidor destino:");
        this.serverDestiono = this.mtdMuestraServidores();
        System.out.println("user:");
        this.userDestino = teclado.nextLine();
        System.out.println("password:");
        this.passwordDestino = teclado.nextLine();
        System.out.println("----------------------------------------");
    }
}
