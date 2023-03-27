package net.dunice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фразу или слово: ");
        String myMessage = scanner.nextLine();

        System.out.println(myCompressor(myMessage));

    }
    private static String myCompressor(String userMessage){
        Map<Character,Integer> messageMap = new LinkedHashMap<>();
        int someNum;
        String myString = "";

        for (Character j: userMessage.toCharArray()){
            if(messageMap.containsKey(j)){
                someNum = messageMap.get(j) + 1;
                messageMap.put(j,someNum);
            }else{
                messageMap.put(j,1);
            }
        }

        for (Object i: messageMap.keySet()){
            myString = myString + i + messageMap.get(i);
        }

        if(myString.length() <= userMessage.length()){
            return myString;
        }else{
            return userMessage;
        }
    }
}
