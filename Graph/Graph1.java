import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class Graph1 {
    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest)
        {
            this.dest = dest;
            this.src = src;
        }
    }
    static void CreateGraph(ArrayList<Edge>[]graph,int V)
    {
        for(int i=0;i<V;i++)
        {
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

    }
    static void getNeighbors(ArrayList<Edge>[]graph,int curr)
    {
        for(int i=0;i<graph[curr].size();i++)
        {
            System.out.print(graph[curr].get(i).dest+" ");
        }
    }
    static void DFS(ArrayList<Edge>[]graph,int curr,boolean[]visit)
    {
        System.out.print(curr+" ");
        visit[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
           Edge edge=graph[curr].get(i);
           if(!visit[edge.dest])
           {
            DFS(graph,edge.dest,visit);
           }
        }
    }
    // if there are disconnected components in the graph then we need to change the code like below
    static void DFSforDisconnect(ArrayList<Edge>[]graph,int curr,boolean[]visit){
        System.out.print(curr+" ");
        visit[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
          Edge edge=graph[curr].get(i);
          if(!visit[edge.dest]){
            DFSforDisconnect(graph,edge.dest,visit);
          }
        }
    }
    
    static void BFS(ArrayList<Edge>[] graph){

        Queue<Edge>q=new LinkedList<>();
        boolean[] visit=new boolean[graph.length];
        q.add(new Edge(0,0));
        while(!q.isEmpty()){
            int curr=q.poll().dest;
            if(!visit[curr])
            {
              System.out.print(curr+" ");
              visit[curr]=true;
              for(int i=0;i<graph[curr].size();i++){
                q.add(graph[curr].get(i));
              }
            }
        }
    }
    static void BFSforDisconnected(ArrayList<Edge>[] graph,int node,boolean[]visit){

        Queue<Integer>q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int curr=q.poll();
            if(!visit[curr])
            {
              System.out.print(curr+" ");
              visit[curr]=true;
              for(int i=0;i<graph[curr].size();i++){
                q.add(graph[curr].get(i).dest);
              }
            }
        }
    }
    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge>[]graph=new ArrayList[V];
        CreateGraph(graph,V);
        // getNeighbors(graph, 6);
        // DFS(graph, 0,new boolean[V]); This will not work for disconnected graphs
        // DFS code for disconnted components
        boolean[]visit=new boolean[V];
        // for(int i=0;i<V;i++)
        // {
        //     if(visit[i]==false)
        //     {

        //         DFSforDisconnect(graph,i,visit);
        //     }
        // }
        BFS(graph);
        System.out.println();
        for(int i=0;i<V;i++)
        {
            if(visit[i]==false){
                BFSforDisconnected(graph,i,visit);
            }
        }
    }
}
