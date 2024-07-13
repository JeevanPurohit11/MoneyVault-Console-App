public class BankView {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayAccountDetails(BankAccount account) {
        account.displayAccountDetails();
    }
}