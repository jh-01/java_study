import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Main {
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int dfs(int startX, int startY){
        visited[startX][startY] = true;
        int result = 1;

        for(int i = 0; i < 4; i++){
            int vx = startX + dx[i];
            int vy = startY + dy[i];

            if(vx < 0 || vx >= N || vy < 0 || vy >= N){
                continue;
            }

            if(!visited[vx][vy] && map[vx][vy] == 1){
                visited[vx][vy] = true;
                result += dfs(vx, vy);
            }
        }
        return result;
    }

    public static void main(String[] args){
        ArrayList<Integer> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String s = sc.nextLine();
            for(int j = 0; j < N; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    result.add(dfs(i, j));
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for(int size : result){
            System.out.println(size);
        }
    }
}