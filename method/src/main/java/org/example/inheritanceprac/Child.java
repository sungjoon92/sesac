package org.example.inheritanceprac;

public class Child extends Parent{
    public String childValue = "childValue";

    public String parentValue = "parent value in child";

    //생성자 함수
    public Child(String publicValue) {
        super(publicValue);
    }

    // 생성자 함수
    public Child(String publicValue, String childValue) {
        super(publicValue);
        this.childValue = childValue;
    }

    // 자식 확인용 메서드
    public void childMethod() {
        System.out.println("child Method");
    }// childMethod() end

    //  super로 부모객체생성후 출력
    public void publicMethod() {
        super.publicMethod();
        System.out.println(super.publicValue);
        System.out.println(super.parentValue);
        System.out.println(super.protectedValue);
        System.out.println("child public method");
    }// publicMethod() end


}
