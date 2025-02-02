class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        Queue<Integer> q=new ArrayDeque<>();
        int[] dist=new int[V];
        int[] degree=new int[V]
        for(int i=0;i<E;i++)
        {
            degree[edges[i][1]]++;
        }
        for(int i=0;i<dist.length;i++)
        dist[i]=Integer.MAX_VALUE;
        dist[0]=0;
        for(int i=0;i<E;i++)
        {
            if(degree[i]==degree[0]){
            q.add(i);
            }
        }
        while(!q.isEmpty())
        {   int point=q.remove();
            for(int i=0;i<E;i++)
            {
                if(edges[i][0]==point)
                {
                    if(dist[point]+edges[i][2]<dist[edges[i][1]])
                    {
                        dist[edges[i][1]]=dist[point]+edges[i][2];
                        q.add(edges[i][1]);
                    }
                }
            }
        }
        return dist;
    }
}