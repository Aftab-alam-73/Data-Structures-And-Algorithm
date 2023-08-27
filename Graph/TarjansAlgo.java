import java.util.ArrayList;

public class TarjansAlgo {
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
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }
    static void dfs(ArrayList<Edge>[]graph,boolean[]visit,int[]dt,int[]low,int curr,int time,int par)
    {
        visit[curr] = true;
        dt[curr] =low[curr]=++time;
       
        System.out.println("discovery time of "+curr+":" +dt[curr]);
       
        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e = graph[curr].get(i);
            if(e.dest==par){
                continue;
            }
            if(!visit[e.dest])
            {
                dfs(graph, visit, dt, low, e.dest, time, curr);
                low[curr]=Math.min(low[curr],low[e.dest]);
                if(dt[curr]<low[e.dest]){
                    System.out.println("Bridge is: " + curr+"---"+e.dest);
                }
            }else{
                low[curr]=Math.min(low[curr],dt[e.dest]);
            }
        }
    }
    static void getBridges(ArrayList<Edge>[]graph,int V)
    {
        int[]dt=new int[V];
        int[]low=new int[V];
        int time=0;
        boolean[]visit=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visit[i])
            {
                dfs(graph,visit,dt,low,i,time,-1);
            }
        }
    }

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[]graph=new ArrayList[V];
        createGraph(graph);
        getBridges(graph, V);
    }
}
