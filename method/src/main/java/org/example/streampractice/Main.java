package org.example.streampractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        System.out.println(integers);

        List<Integer> integers2 = new ArrayList<Integer>(List.of(1, 2, 3, 4));
        System.out.println(integers2);

        List<Integer> list = new ArrayList<Integer>(List.of(2, 3, 1, 5, 6, 8, 3, 2));

        // stream을 사용해 list배열안에 3이상인 원소만 뽑아내는법
        List<Integer> overlist = list.stream() // list를 stream으로 변경
                .filter(x -> x > 2).collect(Collectors.toList());

        System.out.println(overlist);


        // 짝수만 반환
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumber = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumber);

        // 모든 숫자에 2를 곱하여 리스트 반환
        List<Integer> twoMultiply = numbers.stream().map(x -> x * 2).collect(Collectors.toList());
        System.out.println(twoMultiply);

        // 숫자들의 합계 계산
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        // 5보다 큰 숫자의 개수 계산
        int fiveMoreCount = (int) numbers.stream().filter(x -> x > 5).count();
        System.out.println(fiveMoreCount);


        List<String> words = Arrays.asList("apple", "banana", "cherry", "pineapple", "apple");

        // 길이가 5이상인 단어들만 필터링하여 리스트 반환
        List<String> lengthIsFive = words.stream().filter(x -> x.length() >= 5)
                .collect(Collectors.toList());
        System.out.println(lengthIsFive);


        // 모든 단어들을 대문자로 변환하여 리스트 반환
        List<String> uppercase = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(uppercase);

        // 중복된 단어 제거하고 알파벳 순 정렬하여 리스트 반환
        List<String> array = words.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(array);

        // 각 단어의 길이를 리스트로 변환
        List<Integer> arrayLength = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(arrayLength);


        List<Product> products = Arrays.asList(
                new Product("notebook", 1200000, "SALE"),
                new Product("mouse", 50000, "SALE"),
                new Product("keyboard", 150000, "SOLD_OUT"),
                new Product("monitor", 350000, "SOLD_OUT"),
                new Product("speaker", 400000, "SALE")

        );

        // 상품들의 이름 리스트 반환
        List<String> productsName= products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println(productsName);

        // 20만원 이상인 상품들의 이름 리스트 반환
        List<String> twoHundredThousand = products.stream()
                .filter(x-> x.getPrice() >= 200000)
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println(twoHundredThousand);

        // 판매중인 상품의 가격 합
        int sumGoods = products.stream()
                .filter(x -> x.getStatus().equals("SALE"))
                .mapToInt(Product::getPrice).sum();
        System.out.println(sumGoods);

        // 판매 중이면서 20만원 이상인 상품들의 이름 리스트 반환
        List<String> ProductsSaleName = products.stream()
                .filter(x -> x.getStatus().equals("SALE") && x.getPrice() >= 200000)
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println(ProductsSaleName);
    }
}

