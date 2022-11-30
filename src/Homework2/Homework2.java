package Homework2;

import java.util.Random;

public class Homework2 {
    static Employee generateEmployee(){

        /*
         String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

         */

        //TODO: Доработать реализацию
        //return null;
        String[] names = new String[]{"Anna", "Kolya", "Mikhail", "Viki", "Artem"};
        String[] surnames = new String[]{"Ivanova", "Petrov", "Sidorov", "Kruglova", "Ovalov"};
        int[]salaryWorker = new  int[]{10000,50000,60000,70000,80000};
        int[]salaryFreelancer= new  int[]{1000,5000,6000,7000,8000};

        Random random = new Random();
        boolean number = random.nextBoolean();
        if (number) {
            return new Worker(names[random.nextInt(names.length)],surnames[random.nextInt(surnames.length)],
                    salaryWorker[random.nextInt(salaryWorker.length)]);
        } else {
            return new Freelancer(names[random.nextInt(names.length)],surnames[random.nextInt(surnames.length)],
                    salaryFreelancer[random.nextInt(salaryFreelancer.length)]);
        }
    }




    public static void main(String[] args) {
       // Employee worker1 = new Worker("Анатолий", "Шестаков", 40000);
        //System.out.println(worker1);

        //TODO: 1. Доработать метод generateEmployee, вы должны уметь возвращать все типы
        // сотрудников.
        //TODO: 2***. Сотрудник формируется автоматически, метод generateEmployee не имеет параметров.


        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();

        }

        for (Employee e: employees) {
            System.out.println(e);
        }

    }

}

/**
 * Работник (базовый класс)
 */
abstract class Employee{
    protected String name;
    protected String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Ставка
     */
    protected double salary;

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract double calculateSalary();

}

class Freelancer extends Employee{

    public Freelancer(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return 20 * 8 * salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Среднемесячная заработная плата: %.2f (руб.); Почасовая ставка: %.2f (руб.)",
                surname, name, calculateSalary(), salary);
    }
}

/**
 * Рабочий (фулл-тайм)
 */
class Worker extends Employee{


    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.)",
                surname, name, salary);
    }

}
