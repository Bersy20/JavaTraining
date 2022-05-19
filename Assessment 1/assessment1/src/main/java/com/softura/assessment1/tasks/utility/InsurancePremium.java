package com.softura.assessment1.tasks.utility;

import com.softura.assessment1.tasks.models.Customer;

import java.util.Scanner;

public class InsurancePremium {
    public static int getTotalMontlyPremium(){
        int[] monthlyList ={1000,2300,135,234,234,12346,12345,12345,876,456,34,124 };
        int sum=0;
        for (int i : monthlyList) {
            sum=sum+i;
        }
        return sum;
    }

    public static int getTotalQuarterlyPremium(){
        int[] quarterlyList ={1000,2300,135,234};
        int sum=0;
        for (int i : quarterlyList) {
            sum=sum+i;
        }
        return sum;
    }

    public static int getTotalBiAnnualPremium(){
        int[] biAnnualList ={1000,2300};
        int sum=0;
        for (int i : biAnnualList) {
            sum=sum+i;
        }
        return sum;
    }

    public static int getTotalAnnualPremium(){
        int[] annualList ={102300};
        int sum=0;
        for (int i : annualList) {
            sum=sum+i;
        }
        return sum;
    }

    public static void main(String args[]){
        int[] premiumLists=new int[5];

        System.out.println("*********** Menu ************");
        System.out.println("1. Monthly Premium");
        System.out.println("2. Quarterly Premium");
        System.out.println("3. Bi Annual");
        System.out.println("4. Annual");

        Scanner scanner=new Scanner(System.in);

        Customer customer=null;
        int pre = 0;
        for (int i=0;i<5;i++) {

            customer=new Customer();
            System.out.println("Enter name of Customer "+(i+1)+" : ");
            String name = scanner.nextLine();
            customer.setName(name);

            System.out.println("Enter Id of Customer "+(i+1)+" : ");
            int id = scanner.nextInt();
            customer.setCustomerId(id);
            scanner.nextLine();

            System.out.println("Select the plan for Investment Premium : ");
            int type = scanner.nextInt();
            scanner.nextLine();
            switch (type){
                case 1:
                    pre = getTotalMontlyPremium();
                    System.out.println("Total Investment Premium for Customer "+(i+1)+" : "+pre);
                    break;
                case 2:
                    pre = getTotalQuarterlyPremium();
                    System.out.println("Total Investment Premium for Customer "+(i+1)+" : "+pre);
                    break;
                case 3:
                    pre = getTotalBiAnnualPremium();
                    System.out.println("Total Investment Premium for Customer "+(i+1)+" : "+pre);
                    break;
                case 4:
                    pre = getTotalAnnualPremium();
                    System.out.println("Total Investment Premium for Customer "+(i+1)+" : "+pre);
                    break;
                default:
                    System.out.println("Please select valid menu option...");
            }

            premiumLists[i]=pre;
        }
        int totalSum=0;
        for (int i: premiumLists){
            totalSum=totalSum+i;
            customer.setAmount(totalSum);
        }
        System.out.println("Total premium paid by 5 customers : "+totalSum);
    }
}
