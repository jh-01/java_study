import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // int[][] students = new int[N * N + 1][4];
        List<Integer> students = new ArrayList<>();
        int[][] likes = new int[N*N + 1][4];
        for(int i = 0; i < N * N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            students.add(student);
            for(int j = 0; j < 4; j++){
                likes[student][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] classroom = new int[N + 1][N + 1];
        for(int student : students){
            List<int[]> candidate = new ArrayList<>();

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(classroom[i][j] == 0){
                        int favorCount = 0;
                        int emptyCount = 0;

                        for(int k = 0; k < 4; k++){
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if(nx <= 0 || nx > N || ny <= 0 || ny > N) continue;

                            // 1. 주변에 좋아하는 학생 수 구하기
                            for(int f = 0; f < 4; f++){
                                if(likes[student][f] == classroom[nx][ny]) favorCount++;
                            }

                            // 2. 빈칸 수
                            if(classroom[nx][ny] == 0) emptyCount++;
                        }
                        // 후보리스트에 추가

                        candidate.add(new int[]{i, j, favorCount, emptyCount});
                    }
                }
            }
            // 정렬
            candidate.sort((a, b) -> {
                if(a[2] !=  b[2]) return b[2] - a[2];
                else if(a[3] != b[3]) return b[3] - a[3];
                else if(a[0] != b[0]) return a[0] - b[0];
                else return a[1] - b[1];
            });

            // 선택
            int[] target = candidate.get(0);
            classroom[target[0]][target[1]] = student;
        }

        // 만족도 구하기
        int result = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                int student = classroom[i][j];
                int count = 0;
                int[] studentLikes = likes[student];

                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx <= 0 || nx > N || ny <= 0 || ny > N) continue;

                    for(int f = 0; f < 4; f++){
                        if(classroom[nx][ny] == studentLikes[f]){
                            count++;
                        }
                    }
                }

                int[] score = {0,1,10,100,1000};
                result += score[count];
            }
        }

        System.out.println(result);
    }
}