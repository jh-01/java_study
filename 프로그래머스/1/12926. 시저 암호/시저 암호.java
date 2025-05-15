class Solution {
    public String solution(String s, int n) {
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i); // P 80
            char newChar;
            int tempAscii = (int)temp + n; // 105
            if(temp == ' ') continue;
            if(temp < 91 && tempAscii > 90){
                newChar = (char)((int)'A' + (tempAscii - 90 - 1)); // 65 + (105 - 90 - 1) = 65 + 14 = 79
            }
            else if(temp > 96 && tempAscii > 122)
                newChar = (char)((int)'a' + (tempAscii - 122 - 1));
            else newChar = (char) tempAscii;
            s = s.substring(0, i)
                + Character.toString(newChar)
                + s.substring(i + 1);
        }
        return s;
    }
}