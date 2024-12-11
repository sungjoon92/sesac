package org.example;

public class Problem33 {

        // Class 생성 후 2번째줄부터 아래 코드 복사 + 붙여넣기
        // 클래스 이름은 유지

        public static void main(String[] args) {
            // 함수 실행
//            System.out.println(Solution.solution();
            String word = "hellow";
            solution(word);
            System.out.println(solution(word));
        }

// ////////////////////////////////////////////////////////////////////////////////////
        // 이 부분에 daily algo의 템플릿 복사
        //    public (타입) solution 을
        //    public static (타입) solution 으로 변경

//    문자열에서 모음 개수 세기

    public static int solution(String word) {
            char answer;
            char moems[] = {'a', 'e', 'i', 'o', 'u'};
            int count =0;
            for (int i = 0; i < word.length(); i++) {

                for (int j = 0; j < moems.length; j++) {

                    answer = word.charAt(i);
                    char moem = moems[j];
                if (answer == moem) {

                    count++;
                }// if

                }// for2
            }// for1
            return count;
        }//solution() end
// ////////////////////////////////////////////////////////////////////////////////////
}// class end
