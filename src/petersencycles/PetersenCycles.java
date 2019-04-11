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
        Graph graph = new UndirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(1, 3);
        
        graph.printCycles();
    }
    
}
