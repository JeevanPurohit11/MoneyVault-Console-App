import java.util.Scanner;

public class BankController {
    private Bank model; // Encapsulation
    private BankView view; // Encapsulation

    public BankController(Bank model, BankView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            view.displayMessage("1. Add Account");
            view.displayMessage("2. Deposit");
            view.displayMessage("3. Withdraw");
            view.displayMessage("4. Display Account");
            view.displayMessage("5. Display All Accounts");
            view.displayMessage("6. Exit");
            view.displayMessage("Choose an option:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAccount(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    displayAccount(scanner);
                    break;
                case 5:
                    model.displayAllAccounts();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void addAccount(Scanner scanner) {
        view.displayMessage("Enter Account Type (1: Savings, 2: Checking, 3: Current):");
        int type = scanner.nextInt();

        view.displayMessage("Enter Account Number:");
        String accountNumber = scanner.next();

        view.displayMessage("Enter Account Holder:");
        String accountHolder = scanner.next();

        view.displayMessage("Enter Initial Balance:");
        double balance = scanner.nextDouble();

        BankAccount account = null;

        if (type == 1) {
            view.displayMessage("Enter Interest Rate:");
            double interestRate = scanner.nextDouble();
            account = new SavingsAccount(accountNumber, accountHolder, balance, interestRate);
        } else if (type == 2) {
            view.displayMessage("Enter Overdraft Limit:");
            double overdraftLimit = scanner.nextDouble();
            account = new CheckingAccount(accountNumber, accountHolder, balance, overdraftLimit);
        } else if (type == 3) {
            view.displayMessage("Enter Minimum Balance:");
            double minimumBalance = scanner.nextDouble();
            account = new CurrentAccount(accountNumber, accountHolder, balance, minimumBalance);
        }

        if (account != null) {
            model.addAccount(account);
            view.displayMessage("Account added successfully.");
        } else {
            view.displayMessage("Invalid account type.");
        }
    }

    private void deposit(Scanner scanner) {
        view.displayMessage("Enter Account Number:");
        String accountNumber = scanner.next();

        BankAccount account = model.getAccount(accountNumber);
        if (account != null) {
            view.displayMessage("Enter Amount to Deposit:");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            view.displayMessage("Amount deposited successfully.");
        } else {
            view.displayMessage("Account not found.");
        }
    }

    private void withdraw(Scanner scanner) {
        view.displayMessage("Enter Account Number:");
        String accountNumber = scanner.next();

        BankAccount account = model.getAccount(accountNumber);
        if (account != null) {
            view.displayMessage("Enter Amount to Withdraw:");
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                view.displayMessage("Amount withdrawn successfully.");
            } else {
                view.displayMessage("Insufficient funds or minimum balance not maintained.");
            }
        } else {
            view.displayMessage("Account not found.");
        }
    }

    private void displayAccount(Scanner scanner) {
        view.displayMessage("Enter Account Number:");
        String accountNumber = scanner.next();

        BankAccount account = model.getAccount(accountNumber);
        if (account != null) {
            view.displayAccountDetails(account);
        } else {
            view.displayMessage("Account not found.");
        }
    }
}