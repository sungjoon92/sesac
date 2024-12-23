package org.example.exceptionprac;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // TODO 에러추가
        try {
            System.out.println(  0/0 );
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
            System.out.println("error!");
        }

        try {
            // 문제상황이 발생했다고 가정하자.
            // if (스페셜어택이 불가능하면)
            if (true) {
                throw new RuntimeException("error message");
            }
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("runtime error!");
        }

//        Files.readString(Paths.get("src/main/resoruce"));
//        System.out.println(0/0);


        try {
            func();
        } catch (RuntimeException e) {
            System.out.println("error in func");
        }



    }

    public static void func() {
        System.out.println("run func");
//        발생시킬꺼야 / 에러를
        throw new RuntimeException("func error");
    }



//
//    public int speedUp(){
//        연료를 소모시켜서 속도를 높이겠어.
//        만약 연료가 존재하지 않아요.
//        if (연료가 존재하지 않아){
////            문제상황을 알려저
//            return speed
//        }
//        if (연료가 존재하지 않아){
//            throw new RuntimeException("연료가 없어요")
//            // speed up을 실행시키는 상위 메서드에서
//            // try - catch를 통해 해결
//        }
//        return speed
//    }
//
//    public void 구매(){
//        if (내가 돈이 없어){
//            System.out.println(너 못사);
//        }
//        if (내가 돈이 없어){
//            throw  new RuntimeException()
//        }
//    }




}
