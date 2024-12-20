package org.example.etc;

public enum Day {
    MONDAY(1, "MON"),
    TUESDAY(2, "TUE"),
    WEDNESDAY(3, "WED"),
    THURSDAY(4, "THU"),
    FRIDAY(5, "FRI"),
    SATURDAY(6, "SAT"),
    SUNDAY(7, "SUN");

    // 각 상수의 인스턴스 변수
    private int order;
    private String shortName;

    // 생성자
    Day(int order, String shortName) {
        this.order = order;
        this.shortName = shortName;
    }

    // 각 상수의 인스턴스 메서드
    public String getShortName() {
        return this.shortName;
    }
}