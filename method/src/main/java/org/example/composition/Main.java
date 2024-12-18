package org.example.composition;

public class Main {
    public static void main(String[] args) {
        Pencil pencil = new Pencil("red");
        Person jooni = new Person("성준", pencil);
        jooni.write();

        Pencil blue = new Pencil("blue");
        jooni.setPencil(blue);

        jooni.write();
        System.out.println();

        Pencil yellow = new Pencil("yellow");

        Pencil[] pencils = {pencil, blue, yellow};
        Person lynda = new Person("lynda", pencils);

        lynda.writeMany();

        // 마력
        Engine engine = new Engine(9);

        // 차이름
        Car car = new Car("아반떼", engine);
        // 현재 속도는 마력 * 10만 인 메서드
        car.horsepowerOfTheEngine();

    }
}
