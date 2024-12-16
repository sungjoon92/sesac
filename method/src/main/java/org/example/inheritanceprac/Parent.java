package org.example.inheritanceprac;

public class Parent {
    public String publicValue = "public Value";
    private String privateValue = "private Value";
    protected String protectedValue = "protected Value";

    public String parentValue = "parent";
    // 기본 생성자 
    public Parent(String publicValue) {
        this.publicValue = publicValue;
    }

    // public 확인용 메서드
    public void publicMethod(){
        System.out.println("public method");
    }


}
