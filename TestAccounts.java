public class TestAccounts {
    public static void main(String[] args){

        //Account One
        System.out.println("Test of account one");
        BankAccount acc1 = new BankAccount(AccountType.CURRENT,"AA08899");
        acc1.deposit(1000);
        acc1.deposit(20000);
        System.out.println(acc1.getAccount());
        System.out.printf("Balance: %.2f",acc1.getBalance());
        acc1.performMonthlyMaintenance();

        //Account two
        System.out.println("\nTest of account two");
        BankAccount  acc2 = new BankAccount(AccountType.SAVINGS,"AB45677",20000);
        acc2.performMonthlyMaintenance();
        acc2.deposit(2000);
        acc2.withdraw(500);
        System.out.printf("Balance:%.2f%n",acc2.getBalance());

        //Account three
        System.out.println("\nTest of account three");
        BankAccount acc3 = new BankAccount(AccountType.CURRENT,"WE233",5000);
        acc3.deposit(5000);
        System.out.printf("Balance: %.2f",acc3.getBalance());
        acc3.withdraw(1000);
        System.out.printf("Balance: %.2f",acc3.getBalance());
        boolean success = acc3.transfer(true,acc2,1000);
        System.out.println("Transfer success: " + success);
        System.out.printf("acc3 balance after transfer: %.2f%n", acc3.getBalance());
        System.out.printf("acc2 balance after transfer: %.2f%n", acc2.getBalance());

        //Account four
        System.out.println("\nTest for account four");
        BankAccount acc4 = new BankAccount(AccountType.CURRENT,"HS234");
        acc4.withdraw(500);





    }
}
