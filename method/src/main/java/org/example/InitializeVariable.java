package org.example;

public class InitializeVariable {
    public static void main(String[] args) {
        V1 v1 = new V1();
        System.out.println(v1.value);

        V2 v2 = new V2();
        System.out.println(v2.value);

        V3 v3 = new V3();
        System.out.println(v3.value);
    }
}


class V1 {
    static int staticValue = 30;
    int value = 10;
    String word = "text";
}

class V2 {
    int value;
    String word;

    public V2() {
        this(10, "text");
    }

    public V2(int value, String word) {
        this.value = value;
        this.word = word;
    }
}


class V3 {
    static int staticValue;

    int value;
    String word;

    static {
        if (true) {
            staticValue = 10;
        } else {
            staticValue = 30;
        }
    }// static end

    {
        if (true) {
            this.value = 10;
        } else {
            this.value = 30;
        }
//        this.value = 10;
        this.word = "text";
    }
}