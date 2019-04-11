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
public class UndirectedGraph extends Graph {

    @Override
    public void addEdge(int x, int y) {
        int[] edge = {x, y};
        int[] edgeReversed = {y, x};
        
        if (edges.contains(edge) || edges.contains(edgeReversed)) {
            System.out.println("Edge already exists");
            return;
        }
        
        edges.add(edge);
        
        if (!hasVertex(x)) {
            vertices.add(x);
        }
        if (!hasVertex(y)) {
            vertices.add(y);
        }
    }
    
    @Override
    void findCyclesFromVertex(int x) {
        List<Integer> path = new ArrayList<>();
        path.add(x);
        findCyclesFromPath(path);
    }

    // This method implements DFS, by finding a neighbor of the current node,
    // and recursively calling itself with the neighbor inserted as last node.
    @Override
    void findCyclesFromPath(List<Integer> path) {
        int node = path.get(path.size() - 1);
        
        // We go through all the edges, to find which edges include our current node
        for (int[] edge : edges) {
            for (int i = 0; i < 2; ++i) {
                if (edge[i] == node) {
                    
                    // We get the other node in the edge as neighbor
                    int neighbor = edge[(i + 1) % 2];
                    
                    // If we haven't visited the neighbor node, we'll attach it
                    // to the path and run the algorithm on the new path.
                    if (!didVisit(path, neighbor)) {
                        List<Integer> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        findCyclesFromPath(newPath);
                    }
                    
                    // If 'neighbor' node is visited and is equal to the
                    // beginning of the path, it means we have found a cycle.
                    else if ((path.size() > 2) && (neighbor == path.get(0))) {
                        List<Integer> formatted = formatCycle(path);
                        List<Integer> reversed = reverseCycle(formatted);
                        
                        // We check if the cycle or the reversed form of it are
                        // not already in cycles list.
                        if (isCycleNew(formatted) && isCycleNew(reversed)) {
                            cycles.add(formatted);
                        }
                        
                    }
                }
            }
        }
    }
    
    @Override
    void findAllCycles() {
        for (int vertex : vertices) {
            findCyclesFromVertex(vertex);
        }
    }
    
    // -- HELPERS
    
    // Checks if vertex x has been visited in path
    private Boolean didVisit(List<Integer> path, int x) {
        
        for (int p : path) {
            if (p == x) {
                return true;
            }
        }

        return false;
    }
    
    // Gets the vertex with smallest number in path
    private int getSmallestVertex(List<Integer> path) {
        int min = path.get(0);

        for (int p : path) {
            if (p < min) {
                min = p;
            }
        }

        return min;
    }
    
    // Formats cycle so that it starts with the smallest vertex
    private List<Integer> formatCycle(List<Integer> cycle) {
        List<Integer> result = new ArrayList<>(cycle);
        int s = getSmallestVertex(cycle);
        
        while(result.get(0) != s) {
            int head = result.get(0);
            result.remove(0);
            result.add(head);
        }
        
        return result;
    }
    
    // Generates a formatted cycle in the other direction
    private List<Integer> reverseCycle(List<Integer> cycle) {
        List<Integer> reverse = new ArrayList<>(cycle);
        Collections.reverse(reverse);
        
        return formatCycle(reverse);
    }
    
    private boolean isCycleNew(List<Integer> cycle) {
        
        for (List<Integer> c : cycles) {
            if (c.equals(cycle)) {
                return false;
            }
        }
        
        return true;
    }
    
}
