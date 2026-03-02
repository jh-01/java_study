import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, V;
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
    }

    private static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");

        for(int i = 0; i < graph[start].size(); i++){
            int next = graph[start].get(i);

            if(!visited[next]){
                dfs(next);
            }
        }
    }

    private static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int temp = q.poll();
             System.out.print(temp + " ");
            for(int i = 0; i < graph[temp].size(); i++){
                int next = graph[temp].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
