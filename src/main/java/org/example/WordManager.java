package org.example;

import java.util.Scanner;

public class WordManager {

    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;

    WordManager() {

        wordCRUD = new WordCRUD(s);
    }

    public int showMenu() {

        System.out.print(" \n" +
                "*******************\n" +
                "1. 모든 단어 보기\n" +
                "2. 수준별 단어 보기\n" +
                "3. 단어 검색\n" +
                "4. 단어 추가\n" +
                "5. 단어 수정\n" +
                "6. 단어 삭제\n" +
                "7. 파일 저장\n" +
                "0. 나가기\n" +
                "*******************\n" +
                "=> 원하는 메뉴는? : " );

        return s.nextInt();
    }

    public void startProgram() {

        while (true) {

            int pick = showMenu();

            if (pick == 0) {

                System.out.println("프로그램 종료! 다음에 만나요~ ");
                break;
            }

            if (pick == 1) {

                wordCRUD.listAll();

            }

            if (pick == 4) {

                wordCRUD.addItem();


            }
        }
    }

}
