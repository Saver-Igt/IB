package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordManager pm = new PasswordManager();
        System.out.println(pm.getStr1() + ", " + pm.getStr2() + ", " + pm.getStr3());
        // array start from 0
        pm.setResult();
        System.out.println(pm.getResult());

        ThreadDisappear td = new ThreadDisappear("Enter your password: ");
        Thread t = new Thread(td);

        Scanner scanner = new Scanner(System.in);
        int countMistakes = 0;
        t.start();
        while(countMistakes != 3){
            td.maskStart();
            String password = scanner.nextLine();
            System.out.print("\b");
            td.maskEnd();

            if(password.contentEquals(pm.getResult())){
                System.out.println("Password is correct!");
                System.exit(0);
            }
            System.out.println("Password is not correct! Try again");
            countMistakes++;
        }
        System.out.println("Attempt limit exceeded.");
    }
}