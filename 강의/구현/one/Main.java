package 강의.구현.one;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] plan = s.split(" ");
        
        int x = 1;
        int y = 1;
        // L, R, U, D
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for(int i = 0; i < plan.length; i++){
            char c = plan[i].charAt(0);
            if(c == 'L'){
                if(y + dy[0] < 1) continue;
                x += dx[0];
                y += dy[0];
            }
            else if(c == 'R'){
                if(y + dy[1] > n) continue;
                x += dx[1];
                y += dy[1];
            } else if(c == 'U'){
                if(x + dx[2] < 1) continue;
                x += dx[2];
                y += dy[2];
            } else if(c == 'D'){
                if(x + dx[3] > n) continue;
                x += dx[3];
                y += dy[3];
            }
        }

        System.out.println(x + " " + y);
        sc.close();
    }
}
