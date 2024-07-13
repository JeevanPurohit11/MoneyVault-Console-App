public class Main {
    public static void main(String[] args) {
        Bank model = new Bank();
        BankView view = new BankView();
        BankController controller = new BankController(model, view);

        controller.start();
    }
}