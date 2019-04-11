/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petersencycles;

import graph.*;

/**
 *
 * @author Basir Doost
 */
public class PetersenCycles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph petersen = new PetersenGraph();
        System.out.println("Cycles in a Petersen graph are:");
        petersen.printCycles();
    }
    
}
