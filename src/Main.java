public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);
        System.out.println("Ваш баланс: " + account.getAmount());
        while (true) {
            try {
                account.withDraw(6000);
                System.out.println("Ваш остаток баланса: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("Снимаем остаток: " + e.getRemainingAmount());

                try {
                    account.withDraw(e.getRemainingAmount());
                } catch (LimitException ex) {
                    System.out.println("Непредвиденная ошибка: " + ex.getMessage());
                }

                }
                System.out.println("Ваш остаток баланса после последнего снятия: " + account.getAmount());
                break;
            }
        }
    }
