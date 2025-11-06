import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int M;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph;

    private static int dfs(int start){
        int result = 1;
        visited[start] = true;

        for(int i = 0; i < graph.get(start).size(); i++){
            int temp = graph.get(start).get(i);

            if(!visited[temp]){
                visited[temp] = true;
                result += dfs(temp);
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        M = sc.nextInt();
        sc.nextLine();

        visited = new boolean[N + 1];
        graph = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        System.out.println(dfs(1) - 1);
    }
}
