package 이코테.bfs;

import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    private static int n;
    private static int m;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    private static int bfs(int start){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        // 현재 노드를 방문 처리
        visited[start] = true;
        count++;
        //큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            int x = q.poll();
            for(int i = 0; i < graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if(!visited[y]){
                    q.offer(y);
                    visited[y] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        int [][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            String s = sc.nextLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        
    }
}
