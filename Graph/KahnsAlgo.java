// Kahn's algorithm is used for finding topological sorting of a directed acyclic graph.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgo {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void CreateGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    static void kanhsAlgo(ArrayList<Edge>[]graph)
    {
        // Step 1: find the indegree of all the vertices in the graph
          int[]indegree = new int[graph.length];
          for(int i=0;i<graph.length;i++)
          {
            for(int j=0;j<graph[i].size();j++) 
            {
                Edge e=graph[i].get(j);
                indegree[e.dest]++;
            }
          }
          // Step 2: add the vertices in the queue which has indegree 0;
        //   System.out.println(Arrays.toString(indegree));
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
      // Step 3: take out one by one from the queue and visit its neighbors and decrease the indegree of the neighbors after that check if the indegree of the neighbors become zero or not if yes add it in to the queue.
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");
            for(int i=0 ;i<graph[curr].size();i++)
            {
                Edge e=graph[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest]==0)
                {
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[]graph = new ArrayList[V];
        CreateGraph(graph);
        kanhsAlgo(graph);
    }
}
