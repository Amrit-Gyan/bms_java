
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class AccountCreation implements Processes {

//    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//    LocalDateTime now = LocalDateTime.now();

    private final String[] Name = new String[50];
    private final String[] Address = new String[50];
    private final long[] Contact_no = new long[50];
    private final long[] AadhaarNumber = new long[50];
    private final long[] AccountNumber = new long[50];
    private final int[] Pin = new int[50];
    private final long[] Amount = new long[50];
    long amount;
    String saveDate;
    int i; int k=0;
    long copy=Amount[i];


    Scanner sc = new Scanner(System.in);

            public void createAccount (int j){
        try {
            i=j;

            sc.nextLine();
            System.out.println("\nEnter these details");
            System.out.print("Account Holders Name : ");
            Name[i] = sc.nextLine();

            System.out.print("Account Holders Address : ");
            Address[i] = sc.nextLine();

            System.out.print("Account Holders Contact no. : ");
            Contact_no[i] = sc.nextLong();

            System.out.print("Account Holders Aadhaar no. : ");
            AadhaarNumber[i] = sc.nextLong();

            System.out.print("Account Number for the account : ");
            long random_int = (int) Math.floor(Math.random() * (999999999 - 100000000 + 1) + 999999999);
            AccountNumber[i] = random_int;
            System.out.println(AccountNumber[i]);

            int sample;
            do {
                System.out.print
                        ("Set Pin (In 4 digits, also not beginning with 0): ");
                sample = sc.nextInt();
            } while (sample < 1000 || sample > 9999);
            Pin[i] = sample;

            System.out.print("Initial amount : ");
            Amount[i] = sc.nextLong();

            System.out.println("\t   You can check your Account Details...");
            System.out.println("\t\t<<<Your Account is Created>>>"+"\n\tTo be sure please check your account details by pressing 6.");
            System.out.println("=====================================================\n");
        }catch (Exception e){
            System.out.println("Invalid Input");
        }
        }

        public void display () {
            System.out.println("\nAccount Holder Name : " + Name[k] + "\nHolders Address : " + Address[k] + "\nContact No. : " + Contact_no[k] + "\nAadhaar" +
                    " number : " + AadhaarNumber[k] + "\nAccount Number : " + AccountNumber[k] + "\nBalance : " + Amount[k]+"\n");
            System.out.println("=====================================================\n");
        }


        public void BalanceDisplay () {
        System.out.println("\n\n-------------------------------------------\n\t\tBalance\n-------------------------------------------");
        System.out.println("\nAccount Holder Name : " + Name[k] + "\nAccount Number : " + AccountNumber[k] + "\nBalance : " + Amount[k]+"\n");
        System.out.println("=====================================================\n");
        }

        public void Dreceipt(){
            System.out.print("\nAccount No :"+AccountNumber[k]+"\nAmount Deposited : "+amount);
            System.out.println("\nTime : "+saveDate);
            System.out.println("=====================================================\n");
        }

        public void Wreceipt(){
            System.out.print("\nAccount No :"+AccountNumber[k]+"\nAmount Withdrawal : "+amount);
            System.out.println("\nTime : "+saveDate);
            System.out.println("=====================================================\n");
        }

        public void accountsTotal(){
            for (int j=0;j<=i;j++){
                System.out.println(AccountNumber[j]);
                }
            }


        public void Deposit(long AcNo,String name) {

            for (int j=0;j<=i;j++){
                if (AcNo==AccountNumber[j]){
                    k=j;
                    break;
                }
            }

            try {
                if (AccountNumber[k] == AcNo && Objects.equals(Name[k], name)) {

                    System.out.print("\nEnter amount to deposit : ");
                    amount = sc.nextLong();
                    Amount[k] += amount;

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    saveDate = dtf.format(now);
                    System.out.println("\t\t<<<Deposited Successfully>>>");
                    System.out.print("You want receipt?\npress 1 for 'Yes' or Press any other no. to leave.");
                    int rec = sc.nextInt();
                    if (rec == 1) {
                        System.out.println("\n\n-------------------------------------------\n\t\tDeposit Receipt\n-------------------------------------------");
                        this.Dreceipt();
                    } else {
                        System.out.println("=====================================================\n");
                    }

                } else {
                    System.out.println("\nProvided A/c no. or Name is wrong or does not exist...");
                    System.out.println("=====================================================\n");
                }
            }catch (Exception e){
                System.out.println("Invalid Input ");
            }
        }

        public void Withdraw(long AcNo) {

            for (int j=0;j<=i;j++){
                if (AcNo==AccountNumber[j]){
                    k=j;
                    break;
                }
            }
                if (AccountNumber[k] == AcNo) {
                    int count = 0;
                    while (count < 3) {
                        System.out.print("Enter your pin : ");
                        int pass = sc.nextInt();
                        if (Pin[k] == pass) {
                            System.out.print("Enter amount for withdrawal : ");
                            amount = sc.nextInt();
                            if (Amount[k] > (amount + 500)) {
                                Amount[k] -= amount;

                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                LocalDateTime now = LocalDateTime.now();
                                saveDate= dtf.format(now);
                                count = 4;
                                System.out.println("\t\t<<<Withdrawal Successful>>>");
                                System.out.print("You want receipt?\nPress 1 for yes or any other number to exit : ");
                                int r = sc.nextInt();
                                if (r == 1) {
                                    System.out.println("\n\n-------------------------------------------\n\t\tWithdrawal Receipt\n-------------------------------------------");
                                    this.Wreceipt();
                                    System.out.println("=====================================================\n");
                                } else {
                                    System.out.println("=====================================================\n");
                                }
                            } else {
                                System.out.println("Insufficient Balance for this transaction...");
                                System.out.println("A/c to rule of the bank you must have minimum 500 Rs in your account.");
				count=4;
                            }
                        } else {
                            System.out.println("Incorrect Pin...\nRetry");
                            count++;
                        }
                    }
                    if (count == 3) {
                        System.out.println("Retrying limit is crossed!!!\nTransaction Cancelled...");
                        System.out.println("=====================================================\n");
                    }
                } else {
                    System.out.println("Account does not exist : ");
                    System.out.println("=====================================================\n");
                }

        }

        public void BalanceEnquiry(long AcNo) {
            for (int j=0;j<=i;j++){
                if (AcNo==AccountNumber[j]){
                    k=j;
                    break;
                }
            }

            try {
                if (AccountNumber[k] == AcNo) {
                    this.BalanceDisplay();
                } else {
                    System.out.println("\nAccount number does not exist...");
                    System.out.println("=====================================================\n");
                }
            }catch (Exception e){
                System.out.println("Invalid Input");
            }
        }
        public void Update(long AcNo) {
            for (int j=0;j<=i;j++){
                if (AcNo==AccountNumber[j]){
                    k=j;
                    break;
                }
            }
            try {
                if (AccountNumber[k] == AcNo) {
                    int count = 0;
                    while (count < 3) {
                        System.out.print("Enter Pin : ");
                        int p = sc.nextInt();
                        if (Pin[k] == p) {
                            this.UpdateFunction();
                            count = 4;
                        } else {
                            System.out.println("Wrong Pin...\nRetry");
                            count++;
                        }
                    }
                } else {
                    System.out.println("\nAccount number does not exist!");
                }
            }catch(Exception e){
                System.out.println("Invalid Input");
            }
        }
        public void UpdateFunction() {

            try {
                System.out.println("\nWhat do you want to update?");
                System.out.print("Press 1 : To update Address\nPress 2 : To update Contact No.\nPress 3 : To update Aadhaar\nPress any key to exit\nEnter no. : ");
                int inp = sc.nextInt();
                switch (inp) {
                    case 1 : {
                        System.out.print("Enter Address to update : ");
                        sc.nextLine();
                        String UAdd = sc.nextLine();
                        Address[k] = UAdd;
                        System.out.println("Address Updated Successfully");
                        break;
                    }
                    case 2 : {
                        System.out.print("Enter Contact no. to Update : ");
                        long c = sc.nextLong();
                        Contact_no[k] = c;
                        System.out.println("Contact Number Updated Successfully");
                        break;
                    }
                    case 3 : {
                        System.out.print("Enter Aadhaar Number to Update : ");
                        long a = sc.nextLong();
                        AadhaarNumber[k] = a;
                        System.out.println("Aadhaar updated Successfully");
                        break;
                    }
                    default : {
                        System.out.println("\t\t<<<Exiting>>>");
                        System.out.println("=====================================================\n");
                    }
                }
            }catch (Exception e){
                System.out.println("Invalid Input");
            }
        }

        public void AccountDetails(long AcNo) {
            for (int j=0;j<=i;j++){
                if (AcNo==AccountNumber[j]){
                    k=j;
                    break;
                }
            }
            try {
                if (AccountNumber[k] == AcNo) {
                    int count = 0;
                    while (count < 3) {
                        System.out.print("Enter Pin : ");
                        int p = sc.nextInt();
                        if (p == Pin[k]) {
                            this.display();
                            count = 4;
                        } else {
                            System.out.println("Incorrect Pin\nRetry...");
                            count++;
                        }
                    }
                    if (count == 3) {
                        System.out.println("Trying limit exceeded");
                    }
                } else {
                    System.out.println("\nProvided details are incorrect or Account does not Exist!");
                    System.out.println("=====================================================\n");
                }
            }catch (Exception e){
                System.out.println("Invalid Input");
            }
        }
    }