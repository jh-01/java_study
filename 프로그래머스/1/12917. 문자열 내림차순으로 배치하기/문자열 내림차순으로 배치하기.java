import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.Comparator;

class Solution {
    public String solution(String s) {
        String answer = Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
        return answer;
    }
}