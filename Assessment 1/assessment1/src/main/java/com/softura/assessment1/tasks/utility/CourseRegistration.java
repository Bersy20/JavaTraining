package com.softura.assessment1.tasks.utility;

import com.softura.assessment1.tasks.models.*;

import java.util.*;

public class CourseRegistration {
    static RegisteredCandidates[] registeredCandidates = new RegisteredCandidates[15];
    static int noOfCandidates;
    public static void Register(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of candidates to be registered: ");
        noOfCandidates=scanner.nextInt();
        scanner.nextLine();
        if(noOfCandidates>15){
            System.out.println("You can only register less than 15 Candidates at a time...");
            Register();
        }
        RegisteredCandidates registeredCandidates1 = null;
        Candidates candidates = null;
        Course course = null;
        for (int i=0;i<noOfCandidates;i++){
            candidates = new Candidates();
            course = new Course();
            registeredCandidates1 = new RegisteredCandidates();

            System.out.println("Enter candidate name : ");
            String name = scanner.nextLine();
            candidates.setName(name);

            System.out.println("Enter Candidate mobile number : ");
            long mobile =scanner.nextLong();
            scanner.nextLine();
            candidates.setMobileNo(mobile);

            System.out.println("Enter Roll No : ");
            long rollNo = scanner.nextLong();
            scanner.nextLine();
            candidates.setRollNo(rollNo);

            System.out.println("Enter any 1 course from the below list to register : ");
            for (CourseList courseList : CourseList.values()) {
                System.out.println("- "+courseList);
            }
            String courseName = scanner.nextLine();
            course.setCourseName(CourseList.valueOf(courseName.toUpperCase()));

            System.out.println("Enter the mode of class (Online/Offline)? ");
            String mode = scanner.nextLine();
            course.setModeOfClass(ModeOfClass.valueOf(mode.toUpperCase()));

            System.out.println("Enter the Timing (FullTime/PartTime)? ");
            String timing = scanner.nextLine();
            course.setTiming(Timing.valueOf(timing.toUpperCase()));

            System.out.println("Enter the Fee : ");
            int fee = scanner.nextInt();
            scanner.nextLine();
            course.setCourseFee(fee);

            Random random = new Random();
            int num = random.nextInt(100000);
            String formatted = String.format("%05d", num);
            registeredCandidates1.setGeneralInfo(candidates);

            registeredCandidates1.setDateOfRegistration(java.time.LocalDate.now());
            registeredCandidates1.setRegisterNumber(formatted);

            registeredCandidates1.setCourse(course);
            registeredCandidates[i]=registeredCandidates1;

            System.out.println("Successfully Registered : "+registeredCandidates1);

        }
        System.out.println("Below are the registered Candidates : ");
//        for (RegisteredCandidates i: registeredCandidates ){
//            System.out.println(i);
//        }
        for (int i=0;i<noOfCandidates;i++){
            System.out.println(registeredCandidates[i]);
        }
        menuFunc();
    }
    public static void DeRegister(){
        Scanner scanner=new Scanner(System.in);
        RegisteredCandidates[] filteredCandidates = null;
        System.out.println("Enter the roll No. to be deleted : ");
        long rollNo = scanner.nextLong();
        scanner.nextLine();

        for(int i=0;i<noOfCandidates;i++){
            if(registeredCandidates[i]!=null && registeredCandidates[i].getGeneralInfo().getRollNo()!=rollNo){
                filteredCandidates = new RegisteredCandidates[noOfCandidates];
                filteredCandidates[i]= registeredCandidates[i];
            }
        }
        System.out.println("Registered Candidates after de-Registering rollNo. "+rollNo+" : ");
        for (RegisteredCandidates i:filteredCandidates){
            if(i!=null && filteredCandidates.length>0)
                System.out.println(i);
        }
        registeredCandidates=filteredCandidates;
        menuFunc();
    }
    public static void GetListOfCourses(){
        System.out.println("List of Courses offered: ");
        for (CourseList courseList : CourseList.values()) {
            System.out.println("* "+courseList);
        }
        menuFunc();
    }
    public static void EmployeesPerCourse(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the course to find list of employees registered to the course : ");
        String course = scanner.nextLine();
        System.out.println("Employees registered to the course - "+(course)+" : ");
        for(int i=0;i<noOfCandidates;i++){
            if(registeredCandidates[i]!=null && registeredCandidates[i].getCourse().getCourseName().toString().equals(course)) {
                System.out.println(registeredCandidates[i]);
            }
        }
        menuFunc();
    }

    public static void menuFunc(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("*********** Menu ************");
        System.out.println("1. Register for a course");
        System.out.println("2. De-Register for a course");
        System.out.println("3. List the courses offered");
        System.out.println("4. List the employees registered for a specific course.");
        System.out.println("5. End Process");


        System.out.println("Select any option from the menu :");
        int option=scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1:
                Register();
                break;
            case 2:
                DeRegister();
                break;
            case 3:
                GetListOfCourses();
                break;
            case 4:
                EmployeesPerCourse();
                break;
            case 5:
                System.out.println("Process ended successfully...");
                break;
            default:
                System.out.println("Please enter valid option...");
                break;
        }
    }

    public static void main(String args[]){
        menuFunc();
    }
}
