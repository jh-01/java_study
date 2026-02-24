import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int vertex;
    int weight;

    Node(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}

public class Main {
    private static int N;
    private static int M;
    private static int X;

    private static void dijkstra(int start, List<Node>[] g, int[] dist){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node temp = pq.poll();
            int now = temp.vertex;
            int w = temp.weight;

            if(dist[now] < w) continue;

            for(Node next : g[now]){
                int nextCost = dist[now] + next.weight;
                if(nextCost < dist[next.vertex]){
                    dist[next.vertex] = nextCost;
                    pq.add(new Node(next.vertex, nextCost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[N + 1];
        List<Node>[] reverseGraph = new ArrayList[N + 1];
        int[] toDist = new int[N + 1];
        int[] fromDist = new int[N + 1];
        Arrays.fill(toDist, Integer.MAX_VALUE);
        Arrays.fill(fromDist, Integer.MAX_VALUE);
        
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, t));
            reverseGraph[e].add(new Node(s, t)); // 간선 뒤집기
        }

        dijkstra(X, graph, toDist);        // X → i
        dijkstra(X, reverseGraph, fromDist);   // i → X  

        int answer = 0;
        for(int i = 1; i <= N; i++){
            answer = Math.max(answer, toDist[i] + fromDist[i]);
        }
        System.out.println(answer);
    }
}
