package net.dunice;

import java.util.Scanner;

public class SpaceCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фразу или слово: ");
        String myString = scanner.nextLine();

        System.out.println(compressSpaces(myString));
    }
    private static String compressSpaces(String someString){
        char[] charArray = someString.toCharArray();
        String newString = "" + charArray[0];

        for (int i = 1; i < charArray.length; i++){
            if((charArray[i-1] == ' ') && (charArray[i] == ' ')){
                continue;
            }
            newString += charArray[i];
        }
        return newString;
    }

}
