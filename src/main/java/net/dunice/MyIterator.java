package net.dunice;

public class MyIterator {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5, 6, 7};
        MyIterator someIterator = new MyIterator();

        someIterator.iterate(myArray);

    }
    public void iterate(int[] someArray){
        int counter = 0;
        while(counter < someArray.length){
            System.out.println(someArray[counter]);
            counter++;
        }
    }
}
