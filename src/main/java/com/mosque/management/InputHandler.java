package com.mosque.management;

import com.mosque.management.users.EmergencyContact;
import com.mosque.management.users.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    public static Student promptSignup(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the following credentials: ");
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        System.out.println("First name: ");
        String firstName = sc.nextLine();
        System.out.println("Last name: ");
        String lastName = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Day born: ");
        int day = sc.nextInt();
        System.out.println("Month born: ");
        String month = sc.nextLine();
        System.out.println("Year born: ");
        int year = sc.nextInt();
        System.out.println("Address: ");
        String address = sc.nextLine();
        System.out.println("Telephone Number");
        int telephone = sc.nextInt();
        System.out.println("Allergies: ");
        String allergies = sc.nextLine();
        System.out.println("You can add up to 2 emergency contacts, how many do you want to put: ");
        int emerg = sc.nextInt();
        List<EmergencyContact> emergList = addEmergency(emerg);
        String doB = day + "/" + month + "/" + year;
        return new Student(firstName, lastName, doB, email, address, telephone,
                username, password, allergies, emergList);
    }
    private static List<EmergencyContact> addEmergency(int emerg) {
        int count = 0;
        List<EmergencyContact> list = new ArrayList<EmergencyContact>();
        for (int i = 0; i < emerg; i++){
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the following credentials: ");
            System.out.println("First name: ");
            String firstName = sc.nextLine();
            System.out.println("Last name: ");
            String lastName = sc.nextLine();
            System.out.println("Email: ");
            String email = sc.nextLine();
            System.out.println("Age: ");
            int age = sc.nextInt();
            System.out.println("Address: ");
            String address = sc.nextLine();
            System.out.println("Telephone Number: ");
            int telephone = sc.nextInt();
            System.out.println("Relationship to you: ");
            String relationship = sc.nextLine();
            System.out.println("Alternate contact info");
            String altContact =sc.nextLine();
            System.out.println("Are they your primary contact, true or false");
            boolean primaryContact = sc.nextBoolean();
            if (count==0){
                EmergencyContact emergencyContact1 = new EmergencyContact(firstName, lastName,
                        age, email, address, telephone, relationship, altContact, primaryContact);
                list.add(emergencyContact1);
                count++;
            }
            else{
                EmergencyContact emergencyContact2 = new EmergencyContact(firstName, lastName,
                        age, email, address, telephone, relationship, altContact, primaryContact);
                list.add(emergencyContact2);
            }
        }
        return list;
    }
}
