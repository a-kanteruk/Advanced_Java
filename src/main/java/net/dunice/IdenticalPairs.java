package net.dunice;

import java.util.*;

public class IdenticalPairs {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 3, 3, 4, 5, 6, 2, 4, 5};
        System.out.println(checkIdentity(myArray));
    }
    private static int checkIdentity(int[] someArray){
        Map<Integer, Integer> myMap = new HashMap<>();
        int num;
        int counter = 0;
        for (int i = 0; i < someArray.length; i++){
            num = someArray[i];
            for(int j = 0; j < someArray.length; j++){
                if(someArray[j] == num && i < j){
                    counter++;
                }
            }
        }
        return counter;
    }
}
