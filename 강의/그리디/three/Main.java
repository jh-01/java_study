package 강의.그리디.three;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int[] numArray = Arrays
            .stream(s.split(" "))
            .sorted()
            .mapToInt(Integer::parseInt)
            .toArray();
        int result = 0;

        int i = 0;
        while(true){
            int horor = numArray[i];
            if(horor < n - i){
                result++;
                i += horor;
            } else {
                break;
            }
        }

        System.out.println(result);
    }
}
