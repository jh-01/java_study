import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static int[][] graph;

    private static void bfs(int N, int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i = 1; i <= N; i++){
                if(graph[temp][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
            
        }
    }

    public static void main(String[] args) throws IOException{
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                bfs(N, i);
                result++;
            }
        }
        
        System.out.println(result);
    }
}
