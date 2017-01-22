package javacodes;

import java.util.*;
 
public class Dijkstra {
    
    static int V;
    
    int minDistance(int dist[], Boolean que[])
    {
        
        int min = Integer.MAX_VALUE, index=-1;
 
        for (int i = 0; i < V; i++)
            
            if (que[i] == false && dist[i] <= min)
            {
                min = dist[i];
                
                index = i;
            }
 
        return index;
    }
 
    
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        
        for (int i = 0; i < V; i++)
            
            System.out.println(i+" \t\t "+dist[i]);
    }
 
  
    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V]; 
        
        Boolean que[] = new Boolean[V];
 
       
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            
            que[i] = false;
        }
 
       
        dist[src] = 0;
 
       
        for (int count = 0; count < V-1; count++)
        {
           
            int u = minDistance(dist, que);
 
            
            que[u] = true;
 
           
            for (int i = 0; i < V; i++)
 
                
                if (!que[i] && graph[u][i]!=0 &&
                        
                        dist[u] != Integer.MAX_VALUE &&
                        
                        dist[u]+graph[u][i] < dist[i])
                    
                        dist[i] = dist[u] + graph[u][i];
            
        }
 
      
        printSolution(dist, V);
    }
 
   
    public static void main (String[] args)
    {
        Scanner in=new Scanner(System.in);
        
        System.out.println("Number of vertices:");
        
        V=in.nextInt();
        
       int [][]graph = new int[V][V];
       
       System.out.println("Rows and Column of matrix:");
       
       for(int i=0;i<V;i++)
       {
           for(int j=0;j<V;j++)
               
               graph[i][j]=in.nextInt();
       }
       Dijkstra ob=new Dijkstra();
       
        ob.dijkstra(graph, 0);
    }
}
