package org.example;

public class Main {
    public static void main(String[] args) {

//        int[] size = {
//               width: 100,
//                height: 200
//        };
        // 첫 번째 사각형
        int width1 = 10;
        int height1 = 5;
        int rectangleArea1 = width1 * height1;
        System.out.println(rectangleArea1);

        // 두 번째 사각형
        int width2 = 7;
        int height2 = 3;
        int rectangleArea2 = width2 * height2;
        System.out.println(rectangleArea2);

        // 세 번째 사각형
        int width3 = 1;
        int height3 = 10;
        int rectangleArea3 = width3 * height3;
        System.out.println(rectangleArea3);

        int[] array = new int[6];

        Rectangle rect1 = new Rectangle(100, 200);
        System.out.println(rect1.width);
        System.out.println(rect1.rectangleArea());

        Rectangle rect2 = new Rectangle(10, 20);
        System.out.println(rect2.rectangleArea());


        Rectangle bbb = new Rectangle(10);
        System.out.println(bbb.bbb());

// 원의 둘레구하기
        Circle c1 = new Circle(3);
        System.out.println(c1.radius);
        System.out.println(c1.calclaleArea());

//        - 이름, 나이를 가지고 있는 `Person` 클래스를 구현하시오.

        Person jooni = new Person("쭈니", 3);
        System.out.println(jooni.name);
        System.out.println(jooni.age);
        System.out.println(jooni.person());

//        - 견종, 이름을 가지고, “앉아”, “손”을 할 수 있는 `Dog` 클래스를 구현하시오.

        Dog dog = new Dog("턱시도","냥이", "앉아");
        System.out.println(dog.dogs());
        dog.seat();
        dog.hand();


        Triangle triangle = new Triangle(4);
        System.out.println(triangle.side);
        triangle.Trianglearea();
        System.out.println(triangle.Trianglearea());


        Car myCar = new Car("Avante");
        myCar.increaseSpeed();
        myCar.increaseSpeed();
        myCar.increaseSpeed();
        myCar.decreaseSpeed();
        myCar.showInfo();
        myCar.increaseSpeedByAmount(300);
        myCar.showInfo();


        MP3Player mp3 = new MP3Player("mp3", 20, true);

        mp3.powerOn();
        mp3.showMP3();

        mp3.powerOut();
        mp3.showMP3();

        mp3.powerOn();
        mp3.plusvolume();
        mp3.plusvolume();
        mp3.plusvolume();
        mp3.plusvolume();
        mp3.showMP3();

        mp3.minusVolume();
        mp3.showMP3();

//        mp3.powerOut();
//        mp3.showMP3();

        mp3.minusVolume();
        mp3.minusVolume();
        mp3.minusVolume();
        mp3.minusVolume();
        mp3.showMP3();

        mp3.plusvolume();
        mp3.showMP3();



    }// main() end
} // class end

