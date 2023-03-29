package net.dunice;

import java.util.*;
import java.util.stream.Collectors;

public class EmployersComparator {
    public static void main(String[] args) {
        List<Employer> employersList= new ArrayList<>();
        employersList.add(new Employer("Genry",28,80000, 1));
        employersList.add(new Employer("Mich",33,90000, 3));
        employersList.add(new Employer("Jimm",54,120000, 4));

        System.out.println("Список сотрудников в алфавитном порядке: ");
        employersList.stream().sorted().forEach(System.out::println);

        System.out.println("\nСотрудники с зарплатой больше 100000: ");
        employersList.stream().filter(employer -> employer.getSalary() > 100000).forEach(System.out::println);

        System.out.println("\nСотрудник с максимальной зарплатой: ");
        Optional<Employer> max = employersList.stream().max(new SortBySalary());
        max.ifPresent(System.out::println);

        System.out.println("\nГруппировка сотрудников по имени: ");
        Map<String, List<Employer>> myEmployers = employersList.stream()
                .collect(Collectors.groupingBy(Employer::getName));
        for (Map.Entry<String,List<Employer>> item: myEmployers.entrySet()){
            System.out.println(item);
        }

        System.out.println("\nСреднее значение зарплат всех сотрудников: ");
        double averageSalary = employersList.stream().collect(Collectors.averagingInt(Employer::getSalary));
        System.out.println(averageSalary);

        System.out.println("\nСумма всех зарплат сотрудников: ");
        int sumOfSalary = employersList.stream().collect(Collectors.summingInt(Employer::getSalary));
        System.out.println(sumOfSalary);
    }

}
class Employer implements Comparable<Employer>{
    private String name;
    private int age;
    private int salary;
    private int termOfService;
    Employer(String name, int age, int salary, int termOfService){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.termOfService = termOfService;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public int getTermOfService() {
        return termOfService;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", termOfService=" + termOfService;
    }

    @Override
    public int compareTo(Employer employer) {
        return name.compareTo(employer.getName());
    }
}

class SortBySalary implements Comparator<Employer>{

    @Override
    public int compare(Employer employer1, Employer employer2) {
        if(employer1.getSalary() > employer2.getSalary()){
            return 1;
        } else if (employer1.getSalary() == employer2.getSalary()) {
            return 0;
        }else{
            return -1;
        }
    }
}
class SortByAge implements Comparator<Employer>{

    @Override
    public int compare(Employer employer1, Employer employer2) {
        if(employer1.getAge() > employer2.getAge()){
            return 1;
        } else if (employer1.getAge() == employer2.getAge()) {
            return 0;
        }else{
            return -1;
        }
    }
}
class SortByTermOfService implements Comparator<Employer>{

    @Override
    public int compare(Employer employer1, Employer employer2) {
        if(employer1.getTermOfService() > employer2.getTermOfService()){
            return 1;
        } else if (employer1.getTermOfService() == employer2.getTermOfService()) {
            return 0;
        }else{
            return -1;
        }
    }
}
