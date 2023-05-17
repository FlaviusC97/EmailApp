package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "kacompany.com";

    //Constructor
    public Email (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //call a method asking for the department and return the department
        this.department = setDepartment();

        //call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //combine elements to to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //A method that ask for the department
    private String setDepartment () {
        System.out.print("New worker: " + firstName + " " + lastName + ", Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else { return ""; }
    }

    //A method that generate a random password
    private String randomPassword(int length) {
    String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
    char[] password = new char[length];
    for(int i=0; i<length; i++) {
       int rand = (int) (Math.random() * passwordSet.length());
       password[i] = passwordSet.charAt(rand);
        }
    return new String(password);
    }

    //Set the mailBox capacity
    public void setMailCapacity (int capacity) {
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity () {
        return mailboxCapacity;
    }

    public String getAlternateEmail () {
        return alternateEmail;
    }

    public String getPassword () {
        return password;
    }

    public String showInfo () {
        return "Display name: " + firstName + " " + lastName + "\nCompany email: " + email + "\nMailbox capacity: " + mailboxCapacity + "Mb";
    }


}