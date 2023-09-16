package org.example;


// 싱글톤?

public class Main { // Main은 프로그램 실행용으로 사용된다
    public static void main(String[] args) {

        System.out.println("*** 영단어 마스터 ***");

        new WordManager().startProgram();

    }
}