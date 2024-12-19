package org.example.collectionprac;


import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class MapPractice {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("국어", 10);
        map.put("영어", 20);
        map.put("수학", 100);

        System.out.println(map);

        System.out.println(map.get("국어"));
        // 있니없니?
        System.out.println(map.getOrDefault("사회", 0));
        System.out.println(map.getOrDefault("수학", 0));

        System.out.println(map.size());

        Set<String> keys = map.keySet();


        for (String key : keys) {
            Integer value = map.get(key);
            System.out.println(key + value);
        }
    }
}
