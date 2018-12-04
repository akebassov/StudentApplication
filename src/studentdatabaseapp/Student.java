package studentdatabaseapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {

    private static Student[] student;
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private int costOfCourse = 600;
    private static int id = 1000;

    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

    }

    public void chooseGrade() {
        System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\n Enter student class level: ");
        Scanner in = new Scanner(System.in);
        try {
            this.gradeYear = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Need to enter numbers");
            chooseGrade();
        }

    }

    private void setStudentId() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    public void enroll() {

        do {
            System.out.print("Enter course to enroll (Press Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine().toUpperCase();
            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
        } while (1 != 0);
    }

    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    public void payTuition() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your payment: $");
        try {
            int payment = in.nextInt();
            tuitionBalance = tuitionBalance - payment;
            System.out.println("Thank you for your payment of $ " + payment + " ");
        } catch (InputMismatchException e) {
            System.out.println("Need to enter numbers");
            payTuition();
        }
        viewBalance();
    }

    public String toString() {
        return "Student full name: " + firstName + " " + lastName + "\nGrade year: " + gradeYear +
                "\nHe is ID: " + studentID + "\nEnrolled courses " + courses + "\nBalance: " + tuitionBalance;
    }

    public static void studensNum() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of new students to enroll: ");
        try {
            int numOfStudents = in.nextInt();
            student = new Student[numOfStudents];
        } catch (InputMismatchException e){
            System.out.println("Need to enter numbers");
            studensNum();
        }

        for (int i = 0; i < student.length; i++) {
            student[i] = new Student();
            student[i].chooseGrade();
            student[i].setStudentId();
            student[i].enroll();
            student[i].payTuition();
        }
    }
    public static void viewStudents(){
        for (int i = 0; i < student.length; i++){
            System.out.println(student[i].toString() + "\n");
        }
    }
}
