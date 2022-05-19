package com.softura.assessment1.tasks.utility;


import com.softura.assessment1.tasks.models.DailyWorker;
import com.softura.assessment1.tasks.models.SalariedWorker;
import com.softura.assessment1.tasks.models.Worker;

import java.util.Scanner;

public class WorkerPay {

    public static  void calculatePay(int dayCount,int i){
        int salaryPerDay = 1000;
        int total = salaryPerDay*dayCount;
        System.out.println("Total Salary of Employee "+i+" : "+total);
    }

    public static  void getSalaryWorkerDetails(){
        SalariedWorker salariedWorker=new SalariedWorker();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter name of Worker : ");
        String name=scanner.nextLine();
        salariedWorker.setName(name);
    }

    public static  int getDailyWorkerDetails(){
        DailyWorker dailyWorker=new DailyWorker();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter name of Worker : ");
        String name=scanner.nextLine();
        dailyWorker.setName(name);

        System.out.println("Enter No. of days worked : ");
        int noOfDays=scanner.nextInt();
        dailyWorker.setNoOfDays(noOfDays);
        return noOfDays;
    }


    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter number of Employees : ");
        int appts=scanner.nextInt();
        scanner.nextLine();
        Worker[] workers=new Worker[appts];
        Worker worker=null;
        DailyWorker dailyWorker=null;

        for(int i=0;i<workers.length;i++) {

            worker = new Worker();
            System.out.println("Is Employee "+ (i+1) + " salaried worker (yes/no)? ");
            String type=scanner.nextLine();
            switch (type.toLowerCase()){
                case "yes":
                    getSalaryWorkerDetails();
                    calculatePay(40,i+1);
                    break;
                case "no":
                    int noOfDays = getDailyWorkerDetails();
                    calculatePay(noOfDays,i+1);
                    break;
                default:
                    System.out.println("Please enter valid option...");

            }
        }
    }
}
