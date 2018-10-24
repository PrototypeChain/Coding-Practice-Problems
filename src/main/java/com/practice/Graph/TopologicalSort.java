package com.practice.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    private int vertex;
    private LinkedList<Integer> adjacencyList[];

    TopologicalSort(int v){
        vertex = v;
        adjacencyList = new LinkedList[v];
        for(int i=0;i < v; i++){
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adjacencyList[v].add(w);
    }

    public void topologicalSort(){
        Stack stack = new Stack();
        boolean visited[] = new boolean[vertex];

        for (int i = 0; i < vertex; i++)
            visited[i] = false;

        for(int i = 0; i < vertex; i++){
            if(visited[i] == false){
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    public void topologicalSortUtil(int v , boolean[] visited, Stack stack){
        // Mark the current node as visited.
        visited[v] = true;
        Iterator<Integer> itr = adjacencyList[v].iterator();
        Integer i;
        while (itr.hasNext()){
            i = itr.next();
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(new Integer(v));
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.topologicalSort();
    }
}
