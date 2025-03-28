package controller;

import conexion.clConexion;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class clInsert {

    public clInsert(String server, String user, String password, ArrayList<String> registros, int totRows, int insLimit) {
        Statement stm= null;
        Connection con=null;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Indique 'LIBRERIA.ARCHIVO' para la inserción:");
        String file = teclado.nextLine();
        String ins = "INSERT INTO "+file;

        try {
            con=clConexion.conectar(server,user,password);
            System.out.println("Insertando registros...");

            stm= con.createStatement();
            int totIns = 0;

            for (int i=0;i<registros.size();i++) {
                String sql = ins+" "+registros.get(i);
                stm.execute(sql);
                if((totIns + insLimit) <= totRows){
                    totIns = totIns + insLimit;
                }else{
                    totIns = totIns + (totRows-totIns);
                }
                System.out.println(totIns+" / "+totRows);
            }
            System.out.println("Se insertaron "+totIns+" registros en "+file);
            stm.close();
            con.close();

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar", "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }
}
