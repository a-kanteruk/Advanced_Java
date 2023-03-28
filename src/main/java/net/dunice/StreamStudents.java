package net.dunice;

import java.util.List;

public class StreamStudents {
    public static void main(String[] args) {
        List<Students> myList = List.of( new Students("Вася", 16, Sex.MAN),
                                        new Students("Петя", 23, Sex.MAN),
                                        new Students("Елена", 42, Sex.WOMEN),
                                        new Students("Иван Иванович", 69, Sex.MAN));

        System.out.println("Призывники: ");
        List<Students> warriors = myList.stream()
                .filter(student -> (student.getAge() < 27 && student.getAge() >= 18 && student.sex == Sex.MAN))
                .toList();
        warriors.forEach(System.out::println);

        System.out.println("Трудоспособные: ");
        List<Students> workers = myList.stream()
                .filter(student -> (student.getAge() <= 55 && student.getAge() >= 18 && student.sex == Sex.WOMEN)
                                || (student.getAge() >= 18 && student.getAge() <= 60 && student.sex == Sex.MAN))
                .toList();
        workers.forEach(System.out::println);

    }
}
class Students{
    String name;
    int age;
    Sex sex;
    Students(String name, int age, Sex sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex;
    }
}
enum Sex{
    MAN, WOMEN
}
