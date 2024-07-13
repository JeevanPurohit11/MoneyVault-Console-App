public class CheckingAccount extends BankAccount {
    private double overdraftLimit; // Encapsulation

    public CheckingAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) { // Polymorphism
        if (amount > 0 && getBalance() + overdraftLimit >= amount) {
            deposit(-amount); // using deposit method to update balance
            return true;
        }
        return false;
    }

    @Override
    public void displayAccountDetails() { // Polymorphism
        System.out.println("Checking Account Details:");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder: " + getAccountHolder());
        System.out.println("Balance: " + getBalance());
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}