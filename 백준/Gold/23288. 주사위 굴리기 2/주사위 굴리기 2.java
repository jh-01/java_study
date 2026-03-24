import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dice {
    int top;
    int up;
    int right;
    int x;
    int y;
    
    public Dice(int top, int up, int right, int x, int y){
        this.top = top;
        this.up = up;
        this.right = right;
        this.x = x;
        this.y = y;
    }

    public void move(int top, int up, int right, int x, int y){
        this.top = top;
        this.up = up;
        this.right = right;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, K;
    private static int[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                // 지도에 쓰여있는 수
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(1, 2, 3, 1, 1);
        int dir = 0;
        int score = 0;

        for(int k = 0; k < K; k++){
            int nx = dice.x + dx[dir];
            int ny = dice.y + dy[dir];

            if(!canMove(nx, ny)){
                dir = (dir + 2) % 4;
                nx = dice.x + dx[dir];
                ny = dice.y + dy[dir];
            }

            move(nx, ny, dir, dice);

            score += bfs(nx, ny);

            int a = 7 - dice.top;
            int b = map[nx][ny];

            if(a > b) dir = (dir + 1) % 4;
            else if(a < b) dir = (dir + 3) % 4;
        }

        System.out.println(score);
    }

    private static boolean canMove(int nx, int ny){
        if(nx < 1 || nx > N || ny < 1 || ny > M) return false;
        return true;
    }

    private static void move(int nx, int ny, int d, Dice dice){
        int top = dice.top;
        int up = dice.up;
        int right = dice.right;

        int newTop = top;
        int newUp = up;
        int newRight = right;

        switch (d) {
            case 0: // 동
                newTop = 7 - right;
                newRight = top;
                break;
            case 1: // 남
                newTop = up;
                newUp = 7 - top;
                break;
            case 2: // 서
                newTop = right;
                newRight = 7 - top;
                break;
            case 3: // 북
                newTop = 7 - up;
                newUp = top;
                break;
        }

        dice.move(newTop, newUp, newRight, nx, ny);
    }

    private static int bfs(int x, int y){
        boolean[][] visited = new boolean[N + 1][M + 1];
        Queue<int[]> q = new LinkedList<>();

        int target = map[x][y];
        int count = 1;

        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] != target) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                count++;
            }
        }

        return target * count;
    }
}
