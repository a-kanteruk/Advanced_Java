package net.dunice;

import java.lang.reflect.Array;
import java.util.Scanner;

public class BracketInsertion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фразу или слово: ");
        String myMessage = scanner.nextLine();

        bracketInsertion(myMessage);
    }
    private static void bracketInsertion(String someMessage) {
        char[] message = someMessage.toCharArray();
        String newMessage = "";
        if (message.length % 2 == 1) {
            for (int i = 0; i < message.length; i++) {
                if (i <= (message.length / 2)){
                    newMessage += '(';
                }
                newMessage += message[i];
                if (i >= (message.length / 2)){
                    newMessage += ')';
                }
            }
        }else{
            for (int i = 0; i < message.length; i++) {
                if (i <= ((message.length / 2) - 1)){
                    newMessage += '(';
                }
                if (i == (message.length / 2)) {
                    newMessage += "()";
                }
                newMessage += message[i];
                if (i >= (message.length / 2)){
                    newMessage += ')';
                }
            }
        }
        System.out.println(newMessage);
    }
}
