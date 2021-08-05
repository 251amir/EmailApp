package com.company;

import java.util.Scanner;

public class Email {
    private String name;
    private String lastName;
    private String password;
    private String department;
    private int defaultPasswordLogin = 10;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "emacompany.com";


    //constructor to receive name and lastname
    Email(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
      //  System.out.println("Email created:  " + this.name + "  " + this.lastName);

        //call a method asking for the department -return the department
        this.department = setDepartment();
       // System.out.println("Department: " + this.department);

        //call a method that returns a random pass
        this.password = randomPass(defaultPasswordLogin);
        System.out.println("Your password is:  " + this.password);

        //combine elements to generate Email
        email = name.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
       // System.out.println("Hi your email is: " + email);
    }

    //Ask for department
    private String setDepartment() {
        System.out.println("New Worker: "+name+". Department CODES:\n1 Sales\n2 Development\n3 Accounting\n0 for none\nEnter department codes: ");
        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }

    }

    //generate a random pass
    private String randomPass(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";

        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            //we cascade to int because the return value of math.random is a double
            int rand = (int) (Math.random() * passwordSet.length());
            //The Java String charAt(int index) method returns the character at the specified index
            // For example: s.charAt(0) would return the first character of the string represented by instance s.
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //change the pass
    public void changePassword(String password) {
        this.password = password;
    }

    //showing mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public  String showInfo(){
        return "Display Name: " + name + " " + lastName +
                "\nCompany Email: "+ email +
                "\nMailbox Capacity: " + mailboxCapacity+ "mb";
    }

}
