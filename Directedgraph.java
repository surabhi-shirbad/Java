 import java.util.*;
public class Directedgraph {
   static  class Edge{
        int src;
         int dest;
          Edge(int s , int d){
            this.src= s;
            this. dest= d;
          }
    }
       public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }  
       graph[0].add(new Edge(0,1));
       graph[0].add(new Edge(0,2));
       graph[1].add(new Edge(1,3));
       graph[2].add(new Edge(2,3));
    }

     public static boolean isCycleDirected(ArrayList<Edge> graph[], int curr, boolean vis[], boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for ( int i=0; i<graph[curr].size(); i++){
            Edge e= graph[curr].get(i);
            if( rec[e.dest]){
                return true;
            }else if(!vis[e.dest]){
               isCycleDirected(graph, e.dest, vis, rec);
            }
        }
         rec[curr]=false;
         return false;
     }
    public static void main ( String[] args){
         int V=7;
      ArrayList<Edge> graph[]= new ArrayList[V];
      createGraph(graph);
      System.out.println(isCycleDirected(graph,0,new boolean[V], new boolean[V]));

    }
}
