public class CurrentAccount extends BankAccount {
    private double minimumBalance; // Encapsulation

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double minimumBalance) {
        super(accountNumber, accountHolder, balance);
        this.minimumBalance = minimumBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    @Override
    public boolean withdraw(double amount) { // Polymorphism
        if (amount > 0 && getBalance() - amount >= minimumBalance) {
            deposit(-amount); // using deposit method to update balance
            return true;
        }
        return false;
    }

    @Override
    public void displayAccountDetails() { // Polymorphism
        System.out.println("Current Account Details:");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder: " + getAccountHolder());
        System.out.println("Balance: " + getBalance());
        System.out.println("Minimum Balance: " + minimumBalance);
    }
}