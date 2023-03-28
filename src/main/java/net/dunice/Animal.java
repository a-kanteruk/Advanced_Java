package net.dunice;

import javax.print.DocFlavor;

public class Animal{
    String name;

    public static void main(String[] args) {
        Animal dog = new Dog("Spike", 40);
        Animal cat = new Cat("Luci", 6);
        Animal cat2 = new Cat("Lindy", 3);

        dog.showInfo();
        cat.showInfo();

        cat2.showInfo();
        }

    public void showInfo(){
        System.out.println("Меня зовут " + name);
    }
}

class Dog extends Animal{
    int weight;

    public Dog(String someName, int someWeight){
        this.name = someName;
        this.weight = someWeight;
    }

    public void bark(){
        System.out.println("Гаф! Гаф!");
    }
}

class Cat extends Animal{
    int weight;
    public Cat(String someName, int someWeight){
        this.name = someName;
        this.weight = someWeight;
    }

    public void meow(){
        System.out.println("Мяу, Мяу!");
    }
}


