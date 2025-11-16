import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static int[] dist;
    private static ArrayList<ArrayList<int[]>> graph;

    private static void dijkstra(int start){
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int current = now[0];
            int currentDist = now[1];

            if(dist[current] < currentDist) continue;

            for(int[] next : graph.get(current)){
                int nextNode = next[0];
                int nextWeight = next[1];

                if(dist[nextNode] > currentDist + nextWeight){
                    dist[nextNode] = currentDist + nextWeight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        sc.nextLine();
        int K = sc.nextInt();
        sc.nextLine();

        dist = new int[V + 1];
        graph = new ArrayList<>();
        
        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 1; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            sc.nextLine();

            graph.get(u).add(new int[]{v, w});
        }

        dijkstra(K);
        for(int i = 1; i <= V; i++){
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else System.out.println(dist[i]);
        }
    }
}
