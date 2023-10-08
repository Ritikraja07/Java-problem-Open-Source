package java.solution;

import java.util.*;
public class Topologicalsort {
    static class Edge{
        int  src;
        int dest;
    
        public Edge(int s, int d ){
            this.src=s;
            this.dest= d;
          
        }
    }
    public static void creategraph(ArrayList<Edge>[] graph) {
        
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();

           }
    //0- vertex
    graph[4].add(new Edge(4, 0));
    graph[4].add(new Edge(4, 1));
    //1- vertex
    graph[1].add(new Edge(1, 0)); 
    //2- vertex
    graph[2].add(new Edge(2, 3));
    //3- vertex
    graph[3].add(new Edge(3, 1));
    graph[5].add(new Edge(5, 0)); 
    graph[5].add(new Edge(5, 2)); 

}

public static void Topsort(ArrayList<Edge>[] graph){
    boolean vis[]= new boolean[graph.length];
    Stack<Integer> s= new Stack<>();
    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
            TopsortUtil(graph , i , vis, s);
        }
    }

    while(!s.isEmpty()){
        System.out.print(s.pop() + " ");
    }
}
public static void TopsortUtil(ArrayList<Edge>[] graph, int curr , boolean vis[], Stack<Integer>  s) {
    vis[curr]=true;
    for(int i=0;i<graph[curr].size();i++){
        Edge e= graph[curr].get(i);
        if(!vis[e.dest]){
            TopsortUtil(graph, e.dest, vis, s);
        }
    }
    s.push(curr);
}

public static void main(String args[]) {


           int V=6;
           ArrayList<Edge>[] graph= new ArrayList[V];
           creategraph(graph);
          Topsort(graph);
        
}
}

