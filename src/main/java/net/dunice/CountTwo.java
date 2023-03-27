package net.dunice;

import java.util.Scanner;

public class CountTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num;
        String str;
        int counter = 0;
        System.out.println("Input your number: ");
        int userNumber = scanner.nextInt();

        for (int i = 0; i < userNumber; i++){
            num = i;
            str = num.toString();
            for (Character j: str.toCharArray()){
                if (j.equals('2')){
                    counter++;
                }
            }
        }
        System.out.println("Количество цифр '2' равно: " + counter);
    }
}
