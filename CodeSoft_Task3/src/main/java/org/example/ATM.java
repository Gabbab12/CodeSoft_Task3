package org.example;

import java.util.Scanner;

public class ATM{
        private final BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        public void displayMenu() {
            System.out.println("\nOptions:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter initial account balance: #");
            double initialBalance = scanner.nextDouble();
            BankAccount userAccount = new BankAccount(initialBalance);
            ATM atm = new ATM(userAccount);

            boolean exit = false;

            while (!exit) {
                atm.displayMenu();
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("Account Balance: #" + atm.account.getBalance());
                } else if (choice == 2) {
                    System.out.print("Enter deposit amount: #");
                    double depositAmount = scanner.nextDouble();
                    atm.account.deposit(depositAmount);
                } else if (choice == 3) {
                    System.out.print("Enter withdrawal amount: #");
                    double withdrawalAmount = scanner.nextDouble();
                    if (atm.account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawn: #" + withdrawalAmount);
                    }
                } else if (choice == 4) {
                    exit = true;
                } else {
                    System.out.println("Invalid option. Please choose a valid option.");
                }
            }

            System.out.println("Thank you for using the ATM!");
            scanner.close();
        }
    }