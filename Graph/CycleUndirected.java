import java.util.ArrayList;

public class CycleUndirected {
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

    static boolean isCycle(ArrayList<Edge>[]graph,int curr,int par,boolean[]visit)
    {
           visit[curr]=true;
           for(int i=0;i<graph[curr].size();i++)
           {
              Edge edge=graph[curr].get(i);
              if(visit[edge.dest] && edge.dest!=par)
              {
                return true;
              }
              else if(!visit[edge.dest])
              {
                  if(isCycle(graph,edge.dest,curr,visit)){
                    return true;
                  }
              }
           }
           return false;
    }
    
    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge>[]graph=new ArrayList[V];
        CreateGraph(graph,V);
        boolean[]visit=new boolean[V];
       System.out.println(isCycle(graph,0,-1,visit));
       
    }
}
