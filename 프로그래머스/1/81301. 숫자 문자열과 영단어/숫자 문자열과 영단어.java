class Solution {
    public int solution(String s) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < 10; i++){
            s = s.replaceAll(words[i], Integer.toString(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}