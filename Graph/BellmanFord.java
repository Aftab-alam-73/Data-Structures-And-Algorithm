import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    static class Edge{
        int src;
        int w;
        int dest;
        public Edge(int src, int w, int dest){
            this.src = src;
            this.dest=dest;
            this.w=w;
    }
} 
static void createGraph(ArrayList<Edge>[] graph){
   for(int i=0;i<graph.length;i++){
    graph[i]=new ArrayList<Edge>();
   }
   graph[0].add(new Edge(0,2,1));
   graph[0].add(new Edge(0,4,2));
   graph[1].add(new Edge(1,-4,2));
   graph[2].add(new Edge(2,2,3));
   graph[3].add(new Edge(3,4,4));
   graph[4].add(new Edge(4,-1,1));
}
static void bellmanFord(ArrayList<Edge>[]graph,int src)
{
   
    int[] dist=new int[graph.length];
    for(int i=0;i<graph.length;i++)
    {
        if(i!=src)
        {
            dist[i]=Integer.MAX_VALUE;
        }
    }

    for(int k=0;k<graph.length-1;k++)
    {
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++)
            {
               Edge e=graph[i].get(j);
               int u=e.src;
               int v=e.dest;
               if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.w<dist[v]) 
               {
                   dist[v]=dist[u]+e.w;
               }
            }
        }
    }
    System.out.println(Arrays.toString(dist));
}
public static void main(String[] args) {
    int V=5;
    ArrayList<Edge>[] graph=new ArrayList[V];
    createGraph(graph);
    bellmanFord(graph, 0);
}
}
