package com.softura.assessment1.tasks.utility;

import com.softura.assessment1.tasks.exceptions.AgeException;
import com.softura.assessment1.tasks.exceptions.NameException;
import com.softura.assessment1.tasks.models.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserDefinedException  {
    public static void main(String args[]){
        String[] nameArray = new String[]{};
        List<String> nameList = new ArrayList<>(Arrays.asList(nameArray));
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter number of Employees :");
        int appts=scanner.nextInt();
        scanner.nextLine();

        Employee[] employees=new Employee[appts];

        Employee employee=null;

        for(int i=0;i<employees.length;i++) {

            employee = new Employee();
            System.out.println("Enter name of Employee " + (i+1)+" : ");
            String userName=scanner.nextLine();

            try {
                if(nameList.contains(userName)){
                    throw new NameException();
                }
                else {
                    nameList.add(userName);
                    employee.setName(userName);
                    employees[i]=employee;
                }
            } catch ( NameException ex) {
                System.out.println(ex.getMessage());
                StackTraceElement[] stackTraceElements= ex.getStackTrace();
                System.out.println("Please find the exception details below: ");
                for(StackTraceElement stackTraceElement:stackTraceElements){
                    System.out.println(stackTraceElement.getClassName());
                    System.out.println(stackTraceElement.getMethodName());
                    System.out.println(stackTraceElement.getLineNumber());
                    System.out.println(stackTraceElement.getFileName());
                }
                break;
            }
            System.out.println("Enter age of Employee " + (i+1)+" : ");
            int age=scanner.nextInt();
            scanner.nextLine();
            try {
                if(age<0 || age<18 || age>60){
                    throw new AgeException();
                } else {
                    employee.setAge(age);
                    employees[i]=employee;
                }
            } catch (AgeException ex) {
                System.out.println(ex.getMessage());
                StackTraceElement[] stackTraceElements= ex.getStackTrace();
                System.out.println("Please find the exception details below: ");
                for(StackTraceElement stackTraceElement:stackTraceElements){
                    System.out.println(stackTraceElement.getClassName());
                    System.out.println(stackTraceElement.getMethodName());
                    System.out.println(stackTraceElement.getLineNumber());
                    System.out.println(stackTraceElement.getFileName());
                }
                break;
            }
        }
        System.out.println("Employee List :  ");
        for(Employee employeeObj : employees)
            System.out.println(employeeObj);
    }
}
