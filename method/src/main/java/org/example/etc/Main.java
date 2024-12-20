package org.example.etc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        GenericPrac<Integer> integerGenericPrac = new GenericPrac<Integer>();

        integerGenericPrac.setValue(123);
//        integerGenericPrac.setValue("123");

        GenericPrac<String> stringGenericPrac = new GenericPrac<>();

        stringGenericPrac.setValue("123");

        String word = new String();

        Day monday = Day.MONDAY;
        // 1) .values()
        Day[] days = Day.values();
        System.out.println(Arrays.toString(days));

        // 2) .valueOf()
        Day tuesday = Day.valueOf("TUESDAY");
        System.out.println(tuesday);

        // 3) .name()
        Day friday = Day.FRIDAY;
        String fridayName = friday.name();
        System.out.println(fridayName);

        // 4) .ordinal
        int fridayOrdinal = friday.ordinal();
        System.out.println(fridayOrdinal);

    }
}
