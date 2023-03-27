package net.dunice;

import java.util.Scanner;

public class BracketValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фразу или слово: ");
        String myMessage = scanner.nextLine();

        System.out.println(bracketValidation(myMessage));
    }
    private static boolean bracketValidation(String userMessage){
        int validationNum = 0;

        for (Character i : userMessage.toCharArray()){
            switch (i){
                case ')':
                    validationNum--;
                    break;
                case '(':
                    validationNum++;
                    break;
            }
            if (validationNum < 0){
                break;
            }
        }
        if (validationNum == 0){
            return true;
        }else{
            return false;
        }
    }
}
