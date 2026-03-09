import java.io.*;
import java.util.*;

class Node {
    int vertex;
    int weight;
    
    public Node(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Main {
    private static int N;
    private static int E;
    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        long INF = Integer.MAX_VALUE;

        long case1 = (dist1[v1] == INF || distV1[v2] == INF || distV2[N] == INF)
                ? INF : dist1[v1] + distV1[v2] + distV2[N];
        long case2 = (dist1[v2] == INF || distV2[v1] == INF || distV1[N] == INF)
                ? INF : dist1[v2] + distV2[v1] + distV1[N];

        long result = Math.min(case1, case2);
        System.out.println(result == INF ? -1 : result);
    }

    private static int[] dijkstra(int start){
        int[] dist = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Node(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node temp = pq.poll();

            for(Node next : graph[temp.vertex]){
                int newCost = dist[temp.vertex] + next.weight;

                if(newCost < dist[next.vertex]){
                    dist[next.vertex] = newCost;
                    pq.add(new Node(next.vertex, newCost));
                }
            }
        }

        return dist;
    }

}
