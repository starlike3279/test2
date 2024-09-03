package org.example;

public class main {
    public static void main(String[] args) {
        Container.init();
        new App().run();
        Container.close();
    }
}