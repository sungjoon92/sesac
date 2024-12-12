package org.example;

public class Triangle {
    int side;
    int circumference;

    public Triangle(int side) {
        this.side = side;
        this.circumference = side * 3;
    }


    double Trianglearea(){
        double area = (Math.sqrt(3) / 4) * side * side;
        area = Math.floor(area * 100 / 100);
        return area;
    }
}
