import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    static void CreateGraph(ArrayList<ArrayList<Integer>> graph, int V) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(0);
        graph.get(2).add(1);
        graph.get(2).add(4);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(2);
        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);
    }

    static void getNeighbors(ArrayList<ArrayList<Integer>> graph, int v) {
        for (int i = 0; i < graph.get(v).size(); i++) {
            System.out.print(graph.get(v).get(i) + " ");
        }
    }

    static void DFS(ArrayList<ArrayList<Integer>> graph, int curr,ArrayList<Boolean>visit) {

        visit.set(curr, true);
        System.out.print(curr+" ");

        for (int i = 0; i < graph.get(curr).size(); i++) {
            if (!visit.get(graph.get(curr).get(i))) {
                DFS(graph, graph.get(curr).get(i), visit);
            }
        }
       
    }
  static void BFS(ArrayList<ArrayList<Integer>> graph)
  {
     Queue<Integer> queue = new LinkedList<Integer>();
     queue.add(0);
     boolean[]visit=new boolean[graph.size()];
     while(!queue.isEmpty())
     {
         int  curr=queue.poll();
         visit[0]=true;
        System.out.print(curr+" ");
        for(int i=0;i<graph.get(curr).size();i++)
        {
           
            if(!visit[graph.get(curr).get(i)])
            {
                visit[graph.get(curr).get(i)]=true;
                queue.add(graph.get(curr).get(i));
            }
        }
     }
  }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Boolean>visit=new ArrayList<>(Collections.nCopies(6, false));
        // System.out.println(visit);
        // boolean[] visit = new boolean[6];
        int V = 6;
        CreateGraph(graph, V);
        // getNeighbors(graph, 5);
        // DFS(graph, 0, visit);
        BFS(graph);
    }
}