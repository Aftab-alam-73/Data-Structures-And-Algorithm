import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
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

    static void TopSort(ArrayList<Edge>[] graph) {
        Stack<Integer> s = new Stack<>();
        boolean[] visit = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                TopSortUtil(graph, visit, s, i);
            }
        }
        while(!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }

    private static void TopSortUtil(ArrayList<Edge>[] graph, boolean[] visit, Stack<Integer> stack,int curr) {
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge edge = graph[curr].get(i);
            if (!visit[edge.dest]) {
                TopSortUtil(graph, visit, stack, edge.dest);
            }
        }
        stack.push(curr);
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraph(graph);
        TopSort(graph);
    }
}
