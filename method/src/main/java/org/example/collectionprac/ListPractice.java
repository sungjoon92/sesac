package org.example.collectionprac;

import java.util.ArrayList;

public class ListPractice {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // data 삽입
        list.add(1);
        list.add(2);

        System.out.println(list);

        list.add(1,5);

        System.out.println(list);

        // 접근
        System.out.println(list.get(2));

        list.set(0, 100);

        System.out.println(list);

        // list의 반복을 돈다 "길이" length
        System.out.println(list.size());

        // 값이 있니?
        list.isEmpty();

        if (!list.isEmpty()) {
            list.set(2,3);
        }

        System.out.println(list);


        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        System.out.println(strings);
        strings.get(0);

    }
}
