/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Basir Doost
 */
public class PetersenGraph extends UndirectedGraph {

    public PetersenGraph() {
        super();
        this.addEdge(1, 2);
        this.addEdge(2, 3);
        this.addEdge(3, 4);
        this.addEdge(4, 5);
        this.addEdge(5, 1);
        this.addEdge(1, 6);
        this.addEdge(2, 7);
        this.addEdge(3, 8);
        this.addEdge(4, 9);
        this.addEdge(5, 10);
        this.addEdge(6, 8);
        this.addEdge(8, 10);
        this.addEdge(10, 7);
        this.addEdge(7, 9);
        this.addEdge(9, 6);
    }
    
    
}
