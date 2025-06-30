class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char c;
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            System.out.println("c : " + c);
            int temp = 0;
            
            while(temp < index){
                c++;
                if(c > 'z') c = 'a';
                if(skip.indexOf(c) == -1) temp++;
            }
            answer += c;
        }
        return answer;
    }
}