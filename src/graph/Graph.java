/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.*;

/**
 *
 * @author Basir Doost
 */
public abstract class Graph {
    
    // Graph edges, in form of vertex pairs (i.e. {0,1})
    List<int[]> edges;
    
    // List of vertices
    List<Integer> vertices;
    
    // Each cycle is represented as a list of vertices
    List<List<Integer>> cycles;
    
    
    public Graph() {
        this.edges = new ArrayList<>();
        this.vertices = new ArrayList<>();
        this.cycles = new ArrayList<>();
    }
    
    public boolean hasVertex(int x) {
        for (int v : vertices) {
            if (v == x) return true;
        }
        return false;
    }
    
    public void printCycles() {
        findAllCycles();
        for (List<Integer> c : cycles) {
            for (int i : c) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
    
    // Adds an edge. Adds the vertex as well if they are missing.
    public abstract void addEdge(int x, int y);
    
    // Adds a new vertex with no edges connected.
    public abstract void addVertex(int x);
    
    // Finds cycles starting from a given vertex
    public abstract void findCyclesFromVertex(int x);
    
    // Finds cycles continuing from a path
    public abstract void findCyclesFromPath(List<Integer> path);
    
    // Finds all cycles
    public abstract void findAllCycles();
    
    
    
}
