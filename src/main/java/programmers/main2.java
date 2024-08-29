package programmers;

import java.util.Arrays;

public class main2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcadc";

        System.out.println(solution.solution(s));
    }
}
class Solution {
    public String solution(String s) {
        String answer = "";

        // String을 배열로 변환
        char[] tmp = s.toCharArray();

        System.out.println(tmp);
        // 배열을 오름차순 정렬
        Arrays.sort(tmp);

        return answer;
    }
}