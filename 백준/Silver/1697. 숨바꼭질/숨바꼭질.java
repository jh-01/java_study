import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int K;
    private static int N;

    private static int bfs(int start){
        boolean[] visited = new boolean[100001];
        int[] time = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        time[start] = 0;

        while(!q.isEmpty()){
            int x = q.poll();
            if(x == K) return time[x];

            if(x - 1 >= 0 && !visited[x - 1]){
                time[x - 1] = time[x] + 1;
                visited[x - 1] = true;
                q.add(x-1);
            }

            if(x + 1 <= 100000 && !visited[x + 1]){
                time[x + 1] = time[x] + 1;
                visited[x + 1] = true;
                q.add(x + 1);
            }

            if(x * 2 <= 100000 && !visited[x * 2]){
                time[x * 2] = time[x] + 1;
                visited[x * 2] = true;
                q.add(x * 2);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        System.out.println(bfs(N));
    }
}
