// Dijkastra algorithm is used for finding the shortest path from a source to all the vertices.
//Dijkstra algorithm does not work for negative weight
// Dijkstra algorithm works for directed graphs as well as undirected graphs and same code is used.
// It is a type of Greedy Algorithm that only works on Weighted Graphs having positive weights.

//Time compexity:(E+ElogV) if implemented using Adjacency List.
// Time complexity: O(V^2) if implemented using Adjacancy matrix.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
public class Dijkstra {
    static class Edge {
        int src;
        int w;
        int dest;
        public Edge(int src, int w, int dest) {
            this.src = src;
            this.w = w;
            this.dest = dest;
        }
    }
    static void createGraph(ArrayList<Edge>[]graph)
    {
        for(int i = 0; i < graph.length; i++)
        {
            graph[i] = new ArrayList<Edge>();
        }
        // This is directed graph.
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 4, 2));

        graph[1].add(new Edge(1, 1, 2));
        graph[1].add(new Edge(1, 7, 3));

        graph[2].add(new Edge(2, 3, 4));

        graph[3].add(new Edge(3, 1, 5));

        graph[4].add(new Edge(4, 2, 3));
        graph[4].add(new Edge(4, 5, 5));

        // The below graph is undirected graph.

        // graph[0].add(new Edge(0, 2, 1));
        // graph[0].add(new Edge(0, 4, 2));

        // graph[1].add(new Edge(1, 2, 0));
        // graph[1].add(new Edge(1, 1, 2));
        // graph[1].add(new Edge(1, 7, 3));

        // graph[2].add(new Edge(2, 4, 0));
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 4));

        // graph[3].add(new Edge(3, 7, 1));
        // graph[3].add(new Edge(3, 2, 4));
        // graph[3].add(new Edge(3, 1, 5));

        // graph[4].add(new Edge(4, 2, 3));
        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));

        //  graph[5].add(new Edge(5, 1, 3));
        //  graph[5].add(new Edge(5, 5, 4));

    }
    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
    }
    static void dijkstra(ArrayList<Edge>[]graph, int src){
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src, 0));
        boolean[]visited = new boolean[graph.length];
        int[]distance = new int[graph.length];
        for(int i=0; i<graph.length; i++)
        {
           
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        while(!queue.isEmpty()){
            Pair curr= queue.poll();
            if(!visited[curr.node])
            {
                visited[curr.node] = true;
                for(int i=0;i<graph[curr.node].size();i++)
                {
                    Edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int w=e.w;
                    if(distance[u]+w<distance[v]){
                        distance[v]=distance[u]+w;
                        queue.add(new Pair(v,distance[v]));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[]graph = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph,0);
    }
}
