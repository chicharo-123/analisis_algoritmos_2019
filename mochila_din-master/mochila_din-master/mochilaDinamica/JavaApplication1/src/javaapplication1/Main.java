/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Ofelia
 */
public class Main {
    
        public static void mochila(){
        MochilaD mo = new MochilaD(Item.geraraitems(100,10,10),3);
       mo.buscarSolucion();
     
    }
    public static void main(String[] args) {
        Main.mochila();
	}  
}
