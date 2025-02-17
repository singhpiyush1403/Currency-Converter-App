import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

    
        int pin = 1234;
        int balance = 100000;
        int withdraw, deposit;
        int maxWithdrawLimit = 20000;
        ArrayList<String> transactions = new ArrayList<>();

        System.out.println("Enter Pin: ");
        int pass = sc.nextInt();
        int attempts = 1;
        
        while (pass != pin) {
            attempts++;
            if (attempts > 3) {
                System.out.println("Too many failed attempts. Try again later!");
                System.exit(0);
            }
            System.out.println("Wrong Pin! Attempts left: " + (4 - attempts));
            System.out.println("Re-enter Pin: ");
            pass = sc.nextInt();
        }

        System.out.println("<--- Welcome How may I help you--->");

        while (true) {
            System.out.println("\nChoose your option:");
            System.out.println("1] Balance Check");
            System.out.println("2] Withdraw Money");
            System.out.println("3] Deposit Money");
            System.out.println("4] Transaction History");
            System.out.println("5] Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your Current Balance: INR " + balance);
                    break;

                case 2:
                    System.out.println("Enter Withdrawal Amount: ");
                    withdraw = sc.nextInt();

                    if (withdraw > balance) {
                        System.out.println("Insufficient balance!");
                    } else if (withdraw > maxWithdrawLimit) {
                        System.out.println("Withdrawal limit exceeded! Max limit: INR " + maxWithdrawLimit);
                    } else {
                        System.out.println("Confirm Withdrawal? (1 for Yes, 2 for No): ");
                        int confirm = sc.nextInt();
                        if (confirm == 1) {
                            balance -= withdraw;
                            transactions.add("Withdrawn: INR " + withdraw);
                            System.out.println("Withdrawal Successful!");
                            System.out.println("Remaining Balance: INR " + balance);
                        } else {
                            System.out.println("Transaction Cancelled.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Deposit Amount: ");
                    deposit = sc.nextInt();
                    System.out.println("Confirm Deposit? (1 for Yes, 2 for No): ");
                    int confirm = sc.nextInt();
                    if (confirm == 1) {
                        balance += deposit;
                        transactions.add("Deposited: INR " + deposit);
                        System.out.println("Deposit Successful!");
                        System.out.println("Updated Balance: INR " + balance);
                    } else {
                        System.out.println("Transaction Cancelled.");
                    }
                    break;

                case 4:
                    System.out.println("Transaction History:");
                    if (transactions.isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (String transaction : transactions) {
                            System.out.println(transaction);
                        }
                    }
                    break;

                case 5:
                    System.out.println(" We are Happy to Service you. Thank you. Visit again. Have a great day!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice! Please select a valid option.");
            }
}
}
}


