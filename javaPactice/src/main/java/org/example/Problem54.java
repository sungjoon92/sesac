package org.example;

import java.util.Arrays;

public class Problem54 {

        // Class 생성 후 2번째줄부터 아래 코드 복사 + 붙여넣기
        // 클래스 이름은 유지

        public static void main(String[] args) {
            // 함수 실행
            System.out.println(Arrays.toString(Solution.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5)));

        }

// ////////////////////////////////////////////////////////////////////////////////////
        // 이 부분에 daily algo의 템플릿 복사
        //    public (타입) solution 을
        //    public static (타입) solution 으로 변경
static class Solution {
    public static int[] solution(int[] numbers, int direction) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
//            int element = numbers[1];
            int newIndex = (i + direction + numbers.length) % numbers.length;
            answer[newIndex] = numbers[i];
        }
        return answer;
    }
}
// ////////////////////////////////////////////////////////////////////////////////////
    }
