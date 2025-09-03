package 강의.그리디.one;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;

        while(n != 1){
            if(n % k == 0){
                n /= k;
            } else{
                n -= 1;
            }
            count++;
        }
        System.out.println(count);
        scanner.close();
    }
}