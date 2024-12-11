package org.example;

public class Problem34 {

        // Class 생성 후 2번째줄부터 아래 코드 복사 + 붙여넣기
        // 클래스 이름은 유지

        public static void main(String[] args) {
            // 함수 실행

            String word = "aaa";
            solution(word);
            System.out.println(solution(word));

        }

// ////////////////////////////////////////////////////////////////////////////////////
        // 이 부분에 daily algo의 템플릿 복사
        //    public (타입) solution 을
        //    public static (타입) solution 으로 변경
    //문자열 포매팅

        public static String solution(String word) {
            String result = "%s %s %d";
            String is = "is";
            int num = word.length();

            String answer = String.format(result, word, is, num);
            return answer;
        }
// ////////////////////////////////////////////////////////////////////////////////////
    }
