import java.io.*;
import java.util.*;

public class Main {

    private static boolean[] visited;
    private static List<Integer>[] graph;

    private static int dfs(int start, int depth){
        int count = 1;
        visited[start] = true;

        for(int i = 0; i < graph[start].size(); i++){
            int next = graph[start].get(i);
            if(!visited[next]){
                visited[next] = true;
                count += dfs(next, depth + 1);
            }
        }

        return count;
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int result = dfs(1, 0);
        System.out.println(result - 1);
    }
}
