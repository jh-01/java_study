class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pSize = p.length();
        for(int i = 0; i < t.length() - pSize + 1; i++){
            if(t.substring(i, i + pSize).compareTo(p) <= 0)
                answer++;
        }
        return answer;
    }
}