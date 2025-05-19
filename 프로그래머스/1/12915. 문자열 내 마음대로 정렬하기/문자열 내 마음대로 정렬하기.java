import java.util.Arrays;
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){
            @Override
			public int compare(String s1, String s2) {
                String x = s1.substring(n, n + 1);
                String y = s2.substring(n, n + 1);
                System.out.println("x: " + x);
                System.out.println("y: " + y);
                
                System.out.println(x.compareTo(y));
                if(x.equals(y))
                    return s1.compareTo(s2);
				else return x.compareTo(y);
			}
        });
        return strings;
    }
}