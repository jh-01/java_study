import java.io.*;
import java.util.*;

class Board {
    int X;
    char C;

    public Board(int X, char C){
        this.X = X;
        this.C = C;
    }
}

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 2;
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());

        List<Board> movingInfoList = new ArrayList<>();
        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            movingInfoList.add(new Board(X, C));
        }

        Deque<int[]> snake = new LinkedList<>();

        int hr = 1;
        int hc = 1;
        int tr = 1;
        int tc = 1;
        int direction = 1;
        int timeCount = 0;
        int commandIdx = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        map[hr][hc] = 1;
        map[tr][tc] = 1;
        
        snake.addLast(new int[]{hr, hc});
        while(true){
            timeCount++;
            int nr = hr + dx[direction];
            int nc = hc + dy[direction];

            if(nr > N || nc > N || nr < 1 || nc < 1 || map[nr][nc] == 1){
                break;
            }

            snake.addLast(new int[]{nr, nc});

            if(map[nr][nc] == 2){
                map[nr][nc] = 1;
            } else { // 꼬리 이동
                int[] tail = snake.pollFirst();
                map[tail[0]][tail[1]] = 0;
            }

            map[nr][nc] = 1;
            hr = nr;
            hc = nc;

            if(commandIdx < L && timeCount == movingInfoList.get(commandIdx).X){
                char c = movingInfoList.get(commandIdx).C;
                if(c == 'L') direction = (direction + 3) % 4;
                else direction = (direction + 1) % 4;
                commandIdx++;
            }
        }

        System.out.println(timeCount);
    }
}
