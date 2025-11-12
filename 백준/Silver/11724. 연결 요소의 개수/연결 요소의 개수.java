import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int M;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph;

    private static void dfs(int start){
        visited[start] = true;

        for(int i = 0; i < graph.get(start).size(); i++){
            int next = graph.get(start).get(i);
            if(!visited[next]){
                dfs(next);
            }
            
        }
    }

    public static void main(String[] args){
        int count = 0;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        visited = new boolean[N + 1];
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}

