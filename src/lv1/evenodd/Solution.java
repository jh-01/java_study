package lv1.evenodd;

class Solution {
    public String solution(int num) {
        return (Math.abs(num) % 2) == 0 ? "Even" : "Odd";
    }
}