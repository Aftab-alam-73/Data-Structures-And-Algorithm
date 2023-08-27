import java.util.ArrayList;

public class AllPaths {
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
    static void allPaths(ArrayList<Edge>[] graph,int sr,int dst,String path,boolean[]visit)
    {
        if(sr==dst)
        {
            System.out.print(path+" ");
            return;
        }
        visit[sr] = true;
        for(int i=0;i<graph[sr].size();i++){
            int curr=graph[sr].get(i).dest;
            if(!visit[curr])
            {
                allPaths(graph, curr, dst, path+curr, visit);
            }
        }
        visit[sr] = false;
    }
    
    static int allPathsCount(ArrayList<Edge>[] graph,int sr,int dst,String path,boolean[]visit)
    {
        if(sr==dst)
        {
            
            return 1;
        }
        visit[sr] = true;
        int count=0;
        for(int i=0;i<graph[sr].size();i++){
            int curr=graph[sr].get(i).dest;
            if(!visit[curr])
            {
                count+=allPathsCount(graph, curr, dst, path+curr, visit);
            }
        }
        visit[sr] = false;
        return count;
    }
    static ArrayList<String> allPathsRet(ArrayList<Edge>[] graph,int sr,int dst,String path,boolean[]visit)
    {
        ArrayList<String>ans=new ArrayList<>();
        if(sr==dst)
        {
            
            ans.add(path);
            return ans;
        }
        visit[sr] = true;
        for(int i=0;i<graph[sr].size();i++){
            int curr=graph[sr].get(i).dest;
            if(!visit[curr])
            {
                ans.addAll(allPathsRet(graph, curr, dst, path+curr, visit));
            }
        }
        visit[sr] = false;
        return ans;
    }
    
    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge>[]graph=new ArrayList[V];
        CreateGraph(graph,V);
        boolean[]visit=new boolean[V];
        allPaths(graph,0,5,"0",visit);
        System.out.println();
        System.out.println(allPathsCount(graph,0,5,"0",visit));
        System.out.println(allPathsRet(graph,0,5,"0",visit));
       
    }
}
