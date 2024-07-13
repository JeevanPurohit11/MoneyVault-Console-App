import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts; // Encapsulation

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            System.out.println();
        }
    }
}