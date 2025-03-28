package controller;

import conexion.clConexion;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class clSelect {
    public int totRows;
    public int totColumns;
    public int insLimit;
    public ArrayList<String> registros;
    public clSelect(String server, String user, String password, int insLimit){
        this.insLimit = insLimit;
        ResultSet rs = null;
        Connection co =null;
        Statement stm= null;
        ResultSetMetaData rsmd=null;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese consulta a realizar:");
        String sql = teclado.nextLine();

        try {

            co= clConexion.conectar(server,user,password);
            System.out.println("Consultando datos...");
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            rsmd = rs.getMetaData();

            this.totColumns = rsmd.getColumnCount();

            this.totRows = 0;
            while (rs.next()) {
                this.totRows++;
            }

            rs=stm.executeQuery(sql);

            int countRows = 0;
            int countValues = 0;
            this.registros = new ArrayList<>();
            String reg = "";

            while (rs.next()) {

                countRows++;
                countValues++;

                if(countValues == 1){
                    reg = "VALUES";
                }

                reg = reg+" (";
                for (int i = 1; i <= totColumns; i++) {
                    if(i <= totColumns-1) {
                        reg = reg + "'" + ((rs.getString(i) == null)?"01/01/01":rs.getString(i)) + "',";
                    }else if(countValues < this.insLimit && countRows < this.totRows){
                        reg = reg + "'" + ((rs.getString(i) == null)?"01/01/01":rs.getString(i)) + "'),";
                    }else{
                        reg = reg + "'" + ((rs.getString(i) == null)?"01/01/01":rs.getString(i)) + "')";
                    }
                }

                if(countValues == this.insLimit || countRows == this.totRows){
                    this.registros.add(reg);
                    countValues = 0;
                    //System.out.println(reg);
                }
                System.out.println(countRows+" / "+this.totRows);
            }

            stm.close();
            rs.close();
            co.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}