import java.util.ArrayList;
import java.util.PriorityQueue;
// Time complexity: O(ElogE)
public class PrimsAlgo {
    static class Edge{
        int src;
        int dest;
        int w;
        public Edge(int src, int w, int dest){
            this.src = src;
            this.dest = dest;
            this.w = w;
        }
    }
    static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        Pair(int node, int cost)
        {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p)
        {
            return this.cost-p.cost;
        }
    }

    static void createGraph(ArrayList<Edge>[]graph)
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 10, 1));
        graph[0].add(new Edge(0, 15, 2));
        graph[0].add(new Edge(0, 30, 3));

        graph[1].add(new Edge(1, 10, 0));
        graph[1].add(new Edge(1, 40, 3));

        graph[2].add(new Edge(2, 15, 0));
        graph[2].add(new Edge(2,50, 3));

        graph[3].add(new Edge(3,30, 0));
        graph[3].add(new Edge(3,40, 1));
        graph[3].add(new Edge(3,50, 2));
    }
    static void primsAlo(ArrayList<Edge>[] graph){
      PriorityQueue<Pair> queue = new PriorityQueue<>();
      boolean[]visited = new boolean[graph.length];
      queue.add(new Pair(0, 0));
      int minCost=0;
      while(!queue.isEmpty()) {
          
        Pair curr=queue.poll();
        if(!visited[curr.node]){
            visited[curr.node]=true;
            minCost+=curr.cost;
            for(int i=0;i<graph[curr.node].size();i++)
            {
                Edge e=graph[curr.node].get(i);
                queue.add(new Pair(e.dest, e.w));
            }

        }
      }
      System.out.println("Minimum cost: " + minCost);
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[]graph=new ArrayList[V];
        createGraph(graph);
       
        primsAlo(graph);
    }
}
