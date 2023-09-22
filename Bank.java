
//import Banking3.*;
import java.util.*;

public class Bank {
        int inp=0;
        int i=0;
        AccountCreation Ac=new AccountCreation();

         public void initiate () {
         Scanner sc = new Scanner(System.in);

         System.out.println("<<<<Welcome in XYZ Bank>>>>");
          do{
         System.out.println("----------------------------------------------------");
         System.out.println("Press(1-6) for the following options");
         System.out.println("Press 1 - To Create an Account");
         System.out.println("Press 2 - To Deposit");
         System.out.println("Press 3 - To Withdraw");
         System.out.println("Press 4 - To Check Balance");
         System.out.println("Press 5 - To Update Account");
         System.out.println("Press 6 - To Check Account Details");
         System.out.println("press any other key to Exit");
         System.out.println("----------------------------------------------------\n----------------------------------------------------");
         try {
             inp = sc.nextInt();
             System.out.println("----------------------------------------------------");
         } catch (Exception e) {
             System.out.println("Invalid Input...\nTerminating");
         }

             switch (inp) {
                 case 1 : {
                     System.out.println("-------------------------------------------\n\t\t\tCreating an Account \n-------------------------------------------");
                     sc.nextLine();
                     if(i==0) {
                         System.out.println("Press Enter to start");
                        }
                     Ac.createAccount(i);
                     i++;
                     break;
                 }

                 case 2 : {
                     System.out.println("-------------------------------------------\n\t\t\t\tDeposit \n-------------------------------------------");
                     long AcNo=0;
                     String name=" ";
                     try {
                         System.out.print("Enter your Account number : ");
                         AcNo = sc.nextLong();
                         sc.nextLine();
                         System.out.print("Enter Account holders name : ");
                         name = sc.nextLine();
                     }catch (Exception e){
                         System.out.println("Invalid Input");
                     }
                     Ac.Deposit(AcNo,name);
                     break;
                 }

                 case 3 : {
                     System.out.println("-------------------------------------------\n\t\t\t\tWithdraw \n-------------------------------------------");
                     try {
                         System.out.print("Enter your Account number : ");
                         long AcNo = sc.nextLong();
                         Ac.Withdraw(AcNo);
                     }catch (Exception e){
                         System.out.println("Invalid Input");
                     }
                     break;
                 }
                 
                 case 4 : {
                     System.out.println("-------------------------------------------\n\t\t\tBalance Enquiry \n-------------------------------------------");
                     try {
                         System.out.print("Enter your Account number : ");
                         long AcNo = sc.nextLong();
                         Ac.BalanceEnquiry(AcNo);
                     }catch(Exception e){
                         System.out.println("Invalid Input");
                     }
                     break;
                 }

                 case 5 : {
                     System.out.println("-------------------------------------------\n\t\t\tUpdate Account \n-------------------------------------------");
                     try {
                         System.out.print("Enter your Account No : ");
                         long AcNo = sc.nextLong();
                         Ac.Update(AcNo);
                     }catch (Exception e){
                         System.out.println("Invalid Input");
                     }
                     break;
                 }

                 case 6 : {
                     try {
                         System.out.println("-------------------------------------------\n\t\t\tAccount Details\n-------------------------------------------");
                         System.out.print("Enter your Account No : ");
                         long AcNo = sc.nextLong();
                         Ac.AccountDetails(AcNo);
                     }catch (Exception e){
                         System.out.println("Invalid Input");
                     }
                     break;
                 }

                 default : System.out.println("-------------------------------------------\n\t\tThanks for visiting\n-------------------------------------------");
             }
         }while(inp < 8 && inp > 0);
     }

}