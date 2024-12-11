package org.example;

import java.util.Arrays;

public class ArrayPractice {
    public static void main(String[] args) {
        int number;
        number = 10;

        int[] numbers1;
        numbers1 = new int[5];

        int[] numbers2;
        numbers2 = new int[] {1, 2, 3, 4, 5};

        int[] numbers3 = {1, 2, 3, 4, 5};
        int[] numbers4 = new int[5];

        String s = Arrays.toString(numbers1);

        System.out.println(Arrays.toString(numbers1));
        System.out.println(Arrays.toString(numbers2));
        System.out.println(Arrays.toString(numbers3));

        System.out.println(numbers2 == numbers3);
        System.out.println(Arrays.equals(numbers2, numbers3));

        System.out.println(numbers2.length);


        char[] chars= {'a', 'b', 'c', 'd'};
        for (int i = 0; i < chars.length; i++){
            char element = chars[i];
            System.out.println(element);
        }

        // new for문
        for (char element : chars) {
            System.out.println(element);
        }


    }
}
