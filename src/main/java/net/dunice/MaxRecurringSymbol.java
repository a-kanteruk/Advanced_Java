package net.dunice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxRecurringSymbol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фразу или слово: ");
        String myMessage = scanner.nextLine();

        System.out.println("Самый повторяющийся символ - " + selectSymbol(myMessage));
    }
    private static Character selectSymbol(String userMessage){
        Map<Character,Integer> messageMap = new LinkedHashMap<>();
        int someNum;
        int maxNum = 0;
        Character maxCountSymbol = ' ';

        for (Character j: userMessage.toCharArray()){
            if(messageMap.containsKey(j)){
                someNum = messageMap.get(j) + 1;
                messageMap.put(j,someNum);
            }else{
                messageMap.put(j,1);
            }
        }
        for(Character i: messageMap.keySet()){
            if (messageMap.get(i) > maxNum){
                maxCountSymbol = i;
                maxNum = messageMap.get(i);
            }
        }
        return maxCountSymbol;
    }
}
