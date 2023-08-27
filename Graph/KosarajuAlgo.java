import java.util.ArrayList;
import java.util.Stack;
// Kosaraju's Algorithm is used to find out the strongly connected components in a graph.
// This algorithm is only applicable for the directed graph.
//Strongly connected components:if we can reach to every node from the every node in the graph then it is a strongly connected component.

// The algorithm is.
//1.find the topSort of the graph but print it just let it be in the stack.
//2 create a transpose graph of the graph meaning change the direction of the every edges.
//3.pop out one by one element form the stack and do the dfs traversal on the transpose graph.

// time complexity: dfs + topSort+ transpose= O(V+E)+O(V+E)+O(V+E)=O(V+E)

public class KosarajuAlgo{
    static class Edge{
        int src;
        int dest;

        Edge(int src, int dest)
        {
            this.src = src;
            this.dest = dest;
        }
    }
    static void createGraph(ArrayList<Edge>[]graph)
    {
        for(int i = 0; i < graph.length; i++)
        {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }
    static void kosarajuUtils(ArrayList<Edge>[]graph,int curr,Stack<Integer> stack,boolean[]visit){
        visit[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
           Edge e=graph[curr].get(i);
           if(!visit[e.dest]){
             kosarajuUtils(graph, e.dest, stack, visit);
           }
        }
        stack.push(curr);
    }
    static void dfs(ArrayList<Edge>[]graph,int curr,boolean[]visit)
    {
        visit[curr] = true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
          Edge e=graph[curr].get(i);
          if(!visit[e.dest]){
            dfs(graph, e.dest, visit);
          }
        }
    }
    static void kosarajuAlgo(ArrayList<Edge>[]graph)
    {
        boolean[]visit=new boolean[graph.length];
        Stack<Integer> stack=new Stack<>();
        
        kosarajuUtils(graph, 0, stack, visit);
        System.out.println(stack);
        ArrayList<Edge>[]transpose=new ArrayList[graph.length];
        for(int i=0;i<transpose.length;i++){
            transpose[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<graph.length;i++){
            visit[i]=false;
            for(int j=0;j<graph[i].size();j++){
               Edge e=graph[i].get(j);
               transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        while(!stack.isEmpty())
        {
            int node= stack.pop();
            if(!visit[node]){
                dfs(transpose, node, visit);
                // System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[]graph=new ArrayList[V];
        createGraph(graph);
        kosarajuAlgo(graph);
    }
}