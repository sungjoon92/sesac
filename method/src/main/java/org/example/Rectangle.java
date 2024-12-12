package org.example;


public class  Rectangle {
    int width;
    int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    Rectangle(int width) {
        this.width = width;
    }


    int rectangleArea() {
        return width * height;
    }

    int bbb() {
        return width;
    }
}