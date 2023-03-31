package net.dunice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фразу или слово: ");
        String myMessage = scanner.nextLine();

        System.out.println(compressString(myMessage));

    }
    private static String compressString(String userMessage){
        Map<Character,Integer> messageMap = new LinkedHashMap<>();
        int someNum = 0;
        char[] someArray = userMessage.toCharArray();
        String myString = "";

        for (int i = 0; i < someArray.length; i++){
            if(i == 0){
                myString += someArray[i];
                someNum++;
            }else if (i != 0 && someArray[i] == someArray[i-1]){
                someNum++;
            }else{
                myString += someNum;
                myString += someArray[i];
                someNum = 1;
            }
        }
        myString += someNum;
        if(myString.length() <= userMessage.length()){
            return myString;
        }else{
            return userMessage;
        }
    }
}
