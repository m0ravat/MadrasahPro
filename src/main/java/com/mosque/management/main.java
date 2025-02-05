package com.mosque.management;
import java.util.Scanner;

public class main {
    public static void mainn(String[] args) {
        boolean menu1 = true;
        while (menu1){
            System.out.println("Welcome to MadrasahPro! Would you like to: ");
            System.out.println("1 - Create a student account");
            System.out.println("2 - Log in to a student account");
            System.out.println("3 - Log into a faculty account");
            System.out.println("4 - Find information about our courses");
            System.out.println("5 - Quit");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option){
                case 1:
                    promptSignup();
                    break;
                case 2:
                   login();
                   break;
                case 3: 
                    loginFaculty();
                    break;
                case 4:
                    findInfo();
                    break;
                case 5: 
                    menu1 = false;
                    break;
                case 958355:
                    loginAdmin();
                    break;
            }
            
        }
    }

    private static void loginAdmin() {

    }

    private static void findInfo() {
    }

    private static void loginFaculty() {
    }

    public static void promptSignup(){
        Scanner sc = new Scanner(System.in);
    }
    public static void login(){
        Scanner sc = new Scanner(System.in);
    }
}
