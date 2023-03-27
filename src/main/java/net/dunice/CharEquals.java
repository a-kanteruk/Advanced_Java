package net.dunice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharEquals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую фразу.");
        String message = scanner.nextLine();
        System.out.println("Введите вторую фразу.");
        String secondMessage = scanner.nextLine();

        Map firstMap = myEquals(message);
        Map secondMap = myEquals(secondMessage);

        System.out.println(firstMap.equals(secondMap)?"Yes":"No");
    }
    private static Map myEquals(String userMessage){
        Map<Character,Integer> messageMap = new HashMap();
        int someNum;

        for (Character j: userMessage.toCharArray()){
            if(messageMap.containsKey(j)){
                someNum = messageMap.get(j) + 1;
                messageMap.put(j,someNum);
            }else{
                messageMap.put(j,1);
            }
        }
        return messageMap;
    }
}
