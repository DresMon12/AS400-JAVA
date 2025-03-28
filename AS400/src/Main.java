import controller.*;

public class Main {
    public static void main(String[] args) {

        clLogicaPrincipal objLogicaPrincipal = new clLogicaPrincipal();

        int op = 2;

        while (op >= 1 && op <= 2) {
            if (op == 1) {
                objLogicaPrincipal.mtdRealizarSelect();
                objLogicaPrincipal.mtdRealizarInsert();
            } else if (op == 2) {
                objLogicaPrincipal.mtdSolicitarServidores();
                objLogicaPrincipal.mtdRealizarSelect();
                objLogicaPrincipal.mtdRealizarInsert();
            }
            op = objLogicaPrincipal.mtdMenuOpciones();
        }

        System.out.println("FIN...");
    }
}