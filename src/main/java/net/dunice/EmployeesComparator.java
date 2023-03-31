package net.dunice;

import lombok.Value;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeesComparator {
    public static void main(String[] args) {
        List<Employee> employersList= new ArrayList<>();
        employersList.add(new Employee("Genry",28,80000, 1));
        employersList.add(new Employee("Mich",33,90000, 3));
        employersList.add(new Employee("Jimm",54,120000, 4));

        System.out.println("Список сотрудников в алфавитном порядке: ");
        employersList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nСотрудники с зарплатой больше 100000: ");
        employersList.stream()
                .filter(employer -> employer.getSalary() > 100000)
                .forEach(System.out::println);

        System.out.println("\nСотрудник с максимальной зарплатой: ");
        Optional<Employee> max = employersList.stream()
                .max(new SortBySalary());
        max.ifPresent(System.out::println);

        System.out.println("\nГруппировка сотрудников по имени: ");
        Map<String, List<Employee>> myEmployers = employersList.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        for (Map.Entry<String,List<Employee>> item: myEmployers.entrySet()){
            System.out.println(item);
        }

        System.out.println("\nСреднее значение зарплат всех сотрудников: ");
        double averageSalary = employersList.stream()
                .collect(Collectors.averagingInt(Employee::getSalary));
        System.out.println(averageSalary);

        System.out.println("\nСумма всех зарплат сотрудников: ");
        int sumOfSalary = employersList.stream()
                .collect(Collectors.summingInt(Employee::getSalary));
        System.out.println(sumOfSalary);
    }

}
@Value
class Employee implements Comparable<Employee>{
    final String name;
    final int age;
    final int salary;
    final int termOfService;


    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", termOfService=" + termOfService;
    }

    @Override
    public int compareTo(Employee employer) {
        return name.compareTo(employer.getName());
    }
}

class SortBySalary implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getSalary() - employee2.getSalary();
    }
}
class SortByAge implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getAge() - employee2.getAge();
    }
}
class SortByTermOfService implements Comparator<Employee>{
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getTermOfService() - employee2.getTermOfService();
    }
}