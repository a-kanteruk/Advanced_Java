package net.dunice;

import lombok.Value;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeesComparator {
    public static void main(String[] args) {
        List<Employee> employeesList= new ArrayList<>();
        employeesList.add(new Employee("Genry",28,80000, 1));
        employeesList.add(new Employee("Mich",33,90000, 3));
        employeesList.add(new Employee("Jimm",54,120000, 4));

        System.out.println("Список сотрудников в алфавитном порядке: ");
        employeesList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nСотрудники с зарплатой больше 100000: ");
        employeesList.stream()
                .filter(employee -> employee.getSalary() > 100000)
                .forEach(System.out::println);

        System.out.println("\nСотрудник с максимальной зарплатой: ");
        Optional<Employee> max = employeesList.stream()
                .max(new SortBySalary());
        max.ifPresent(System.out::println);

        System.out.println("\nГруппировка сотрудников по имени: ");
        Map<String, List<Employee>> myEmployees = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        for (Map.Entry<String,List<Employee>> item: myEmployees.entrySet()){
            System.out.println(item);
        }

        System.out.println("\nСреднее значение зарплат всех сотрудников: ");
        double averageSalary = employeesList.stream()
                .collect(Collectors.averagingInt(Employee::getSalary));
        System.out.println(averageSalary);

        System.out.println("\nСумма всех зарплат сотрудников: ");
        int sumOfSalary = employeesList.stream()
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
    public int compareTo(Employee employee) {
        return name.compareTo(employee.getName());
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