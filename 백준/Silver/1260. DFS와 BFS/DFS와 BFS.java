import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static int n;
    private static int m;
    private static int v;
    
    private static void dfs(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited){ // 깊이 우선 / 스택 사용
        visited[v] = true;
        System.out.print(v + " ");

        for(int i = 0; i < graph.get(v).size(); i++){
            int t = graph.get(v).get(i);
            if(!visited[t]){
                dfs(graph, t, visited);
            }
        }
    }

    private static void bfs(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited){ // 너비 우선 / 큐 사용
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);

        visited[v] = true;

        while(!q.isEmpty()){
            int t = q.poll();
            System.out.print(t + " ");
            for(int i = 0; i < graph.get(t).size(); i++){
                int temp = graph.get(t).get(i);
                if(!visited[temp]){
                    q.add(temp);
                    visited[temp] = true;
                }
            }
        }
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        boolean[] visited;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n + 1];
        dfs(graph, v, visited);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(graph, v, visited);

        sc.close();
    }
}
