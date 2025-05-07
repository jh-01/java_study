class Solution {
    public String solution(String phone_number) {
        int star_length = phone_number.length() - 4;
        String answer = ("*".repeat(star_length)) + phone_number.substring(star_length);
        return answer;
    }
}