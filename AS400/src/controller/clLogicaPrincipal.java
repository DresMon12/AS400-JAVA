package controller;

import java.util.Scanner;

public class clLogicaPrincipal {
    private Scanner teclado;
    private clServers objServers;
    private clSelect objSelect;
    private clInsert objInsert;
    private int insLimit;

    public clLogicaPrincipal() {
        this.teclado = new Scanner(System.in);
        this.objServers = new clServers();
        System.out.println("**Bienvenido Script AS400.java - 1.2**");
        System.out.println("**Autor: German A. Montañez H.**");
    }

    public void mtdRegistrosPorInsert(){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Ingrese la cantidad de registros que desea insertar al tiempo en cada INSERT:");
        this.insLimit = teclado.nextInt();
    }

    public void mtdRealizarSelect() {
        try {
            System.out.println("DATA SELECT...");
            this.objSelect = new clSelect(this.objServers.serverOrigen, this.objServers.userOrigen, this.objServers.passwordOrigen, this.insLimit);
            System.out.println("Total de registros:" + this.objSelect.totRows);
            System.out.println("Total de columnas:" + this.objSelect.totColumns);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mtdRealizarInsert() {
        try {
            System.out.println("DATA INSERT...");
            this.objInsert = new clInsert(this.objServers.serverDestiono, this.objServers.userDestino, this.objServers.passwordDestino, this.objSelect.registros, this.objSelect.totRows, this.objSelect.insLimit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mtdSolicitarServidores() {
        this.objServers.mtdSolicitarInformacionServidores();
    }

    public int mtdMenuOpciones() {
        System.out.println("**********************");
        System.out.println("1-Continuar");
        System.out.println("2-Cambiar servidores");
        System.out.println("3-Finalizar");
        System.out.println("**********************");
        System.out.println("op:");
        return teclado.nextInt();
    }
}

