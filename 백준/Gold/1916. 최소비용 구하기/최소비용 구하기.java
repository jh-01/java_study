import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int vertex;
    int weight;

    public Node(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n){
        return this.weight - n.weight;
    }
}

public class Main {
    private static int[] cost;
    private static int N;
    private static int M;
    private static List<Node>[] graph;

    private static void dijkstra(int x, int y){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));
        cost[x] = 0;

        while(!pq.isEmpty()){
            Node temp = pq.poll();

            if(temp.weight > cost[temp.vertex]) continue;
            
            for(Node next : graph[temp.vertex]){
                int newCost = cost[temp.vertex] + next.weight;

                if(newCost < cost[next.vertex]){
                    cost[next.vertex] = newCost;
                    pq.add(new Node(next.vertex, newCost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        cost = new int[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        dijkstra(x, y);
        System.out.println(cost[y]);
    }
}
