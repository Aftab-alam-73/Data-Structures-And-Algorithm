import java.util.ArrayList;

public class CycleDirected {
    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest)
        {
            this.src = src;
            this.dest = dest;
        }
    }
    static void CreateGraph(ArrayList<Edge>[]graph)
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 4));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));

    }
    static boolean isCycle(ArrayList<Edge>[]graph,boolean visit[],boolean stack[],int curr)
    {
        visit[curr] = true;
        stack[curr] =true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest])
            {
                return true;
            }else if(!visit[e.dest]){
                if(isCycle(graph, visit, stack, e.dest)){
                    return true;
                }
            }
        }
        stack[curr]=false;
        return false;
    }
    // counting the number of cycles present in the graph.
    static int NumberOfCycles(ArrayList<Edge>[]graph,boolean visit[],boolean stack[],int curr)
    {
        visit[curr] = true;
        stack[curr] =true;
        int count = 0;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest])
            {
                return 1;
            }else if(!visit[e.dest]){
                count+=NumberOfCycles(graph, visit, stack, e.dest);
                  
                
            }
        }
        stack[curr]=false;
        return count;
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[]graph=new ArrayList[V];
        CreateGraph(graph);
        boolean[]visit=new boolean[V];
        boolean[]stack=new boolean[V];
        boolean ans=false;
        // for(int i=0;i<V;i++)
        // {
        //     if(!visit[i]){

        //         ans=isCycle(graph, visit,stack, i);
        //         if(ans)
        //         {

        //             System.out.println(ans);
        //             break;

        //         }
        //     }
        // }
        int cycles=0;
        for(int i=0;i<V;i++)
        {
            if(!visit[i]){
                
                cycles=cycles+NumberOfCycles(graph, visit, stack, i);
                
            }
        }
        System.out.println(cycles);
    }
}
