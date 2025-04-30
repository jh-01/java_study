import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> coll = Stream.of(String.valueOf(n).split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        Collections.reverse(coll);
        return coll.stream().mapToInt(Integer::intValue).toArray();
    }
}