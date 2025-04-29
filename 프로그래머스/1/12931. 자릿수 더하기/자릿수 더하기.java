import java.util.*;
import java.util.stream.*;

public class Solution {
    public int solution(int n) {
        int sum = Stream.of(String.valueOf(n).split(""))
            .mapToInt(Integer::parseInt)
            .sum();
        return sum;
    }
}