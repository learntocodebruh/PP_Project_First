package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {

    ArrayList<Word> list;
    Scanner s;
    final String fname = "C:\\Users\\manda\\IdeaProjects\\PP_Project_First\\target\\dictionary.txt";

    WordCRUD(Scanner s){

        list = new ArrayList<>();
        this.s = s;
    }


    public Object add() {

        System.out.println();
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int difficulty = s.nextInt();
        String term = s.nextLine();

        System.out.print("뜻 입력 : ");
        String definition = s.nextLine();

        return new Word(0, difficulty, term, definition);
    }

    public void addItem() {

        Word one = (Word)add();

        list.add(one);

        System.out.println();
        System.out.println("새 단어가 단어장에 추가되었습니다 !!!");

    }

    public void listAll() {

        System.out.println();
        System.out.println("------------------------------");

        for (int i = 0; i < list.size(); i++) {

            System.out.print((i + 1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("------------------------------");
    }

    public ArrayList<Integer> listAll(String searched_word) {

        ArrayList<Integer> numlist = new ArrayList<>();
        int j = 0;

        System.out.println();
        System.out.println("------------------------------");

        for (int i = 0; i < list.size(); i++) {

            String search = list.get(i).getTerm();

            if (!search.contains(searched_word)) continue;

            System.out.print((j + 1) + " ");
            System.out.println(list.get(i).toString());
            numlist.add(i);
            j++;
        }
        System.out.println("------------------------------");
        return numlist;
    }

    public void listAll(int difficulty) {

        int j = 0 ;
        System.out.println();
        System.out.println("------------------------------");

        for (int i = 0; i < list.size(); i++) {

            int idifficulty = list.get(i).getDifficulty();

            if (idifficulty != difficulty) continue;

            System.out.print((j + 1) + " ");
            System.out.println(list.get(i).toString());
            j++;
        }
        System.out.println("------------------------------");

    }

    public void updateItem() {

        System.out.println();
        System.out.print("=> 수정할 단어 검색 : ");
        String searched_word = s.next();

        ArrayList<Integer> numlist = this.listAll(searched_word);

        System.out.print("=> 수정할 번호 선택 : ");
        int number = s.nextInt();

        s.nextLine();

        System.out.print("=> 뜻 입력 : ");
        String definition = s.nextLine();

        Word word = list.get(numlist.get(number - 1));

        word.setDefinition(definition);

        System.out.println();
        System.out.print("단어 수정이 성공적으로 되었습니다!! ");
        System.out.println();

    }

    public void deleteItem() {

        System.out.println();
        System.out.print("=> 삭제할 단어 검색 : ");
        String eliminating_word = s.next();

        ArrayList<Integer> numlist = this.listAll(eliminating_word);

        System.out.print("=> 삭제할 번호 선택 : ");
        int eliminating_number = s.nextInt();

        s.nextLine();

        System.out.print("=> 정말로 삭제하실래요?(Y/n) ");
        String really = s.nextLine();

        if (really.equalsIgnoreCase("y")) {
            list.remove((int)numlist.get(eliminating_number - 1));

            System.out.println();
            System.out.print("선택한 단어 삭제 완료 !!!");
            System.out.println();
        }

        else {

            System.out.println();
            System.out.println("사용자가 취소하였습니다");
        }

    }

    public void loadFile() {

        try {

            BufferedReader br = new BufferedReader(new FileReader(fname));

            String line;
            int count = 0;

            while (true) {

                line = br.readLine();

                if (line == null) break;

                String data[] = line.split("\\|");

                int difficulty = Integer.parseInt((data[0]));
                String term = data[1];
                String definition = data[2];

                list.add(new Word (0, difficulty,term, definition));
                count++;
            }

            br.close();
            System.out.println("=> " + count + "개 단어 로딩 완료!");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void saveFile() {

        try {
            PrintWriter pr = new PrintWriter(new FileWriter("temp.txt"));

            for (Word one : list) {

                pr.write(one.toFileString() + "\n");
            }

            pr.close();

            System.out.println();
            System.out.print("모든 단어 파일 저장 완료 !!!");
            System.out.println();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchDifficulty() {

        System.out.print("=> 레벨(1:초급, 2:중급, 3:고급) 선택 : ");
        int difficulty = s.nextInt();

        listAll(difficulty);

    }

    public void searchTerm() {

        System.out.print("=> 검색할 단어 입력 : ");

        String searching = s.next();
        listAll(searching);
    }
}