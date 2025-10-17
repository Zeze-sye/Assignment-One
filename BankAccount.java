public class BankAccount {

    // private attributes
    private double currentBalance ;
    private int numWithdrawalCB;
    private double minBalance;
    private double interestRate;
    private double maintenance;
    private boolean inTheRed;
    private int withdrawalLimit;
    private AccountType account;
    private String id;




    //Constant
    private static final int CURRENT_ACCT_MIN_BALANCE=50;
    private static final int CURRENT_ACCT_MAINTENANCE_FEE=10;
    private static final int SAVINGS_ACCT_MIN_BALANCE=50;
    private static final int SAVINGS_ACCT_INTEREST_RATE=20;
    private static final int SAVINGS_WITHDRAWAL_LIMIT = 2;

    //Constructor
    // without opening balance
    public BankAccount(AccountType type,String id){
        currentBalance =0;
        numWithdrawalCB =0;
        account = type;
        this.id = id;

        // Current Account
        if(account == AccountType.CURRENT){
            minBalance = CURRENT_ACCT_MIN_BALANCE;
            interestRate = 0;
            maintenance =CURRENT_ACCT_MAINTENANCE_FEE;
            withdrawalLimit = -1;
        }
        //Savings Account
        else{
            minBalance = SAVINGS_ACCT_MIN_BALANCE;
            interestRate =SAVINGS_ACCT_INTEREST_RATE;
            maintenance =0;
            withdrawalLimit = SAVINGS_WITHDRAWAL_LIMIT;
        }
        inTheRed = (currentBalance < minBalance);

        }

    // Constructor
    //Opening with money
    public BankAccount(AccountType type,String id, double openingBalance) {
        currentBalance = openingBalance;
        numWithdrawalCB = 0;
        account = type;
        this.id = id;

        if (account == AccountType.CURRENT) {
            minBalance = CURRENT_ACCT_MIN_BALANCE;
            interestRate = 0;
            maintenance = CURRENT_ACCT_MAINTENANCE_FEE;
            withdrawalLimit = -1;
        }
        else {
            minBalance = SAVINGS_ACCT_MIN_BALANCE;
            interestRate = SAVINGS_ACCT_INTEREST_RATE;
            maintenance = 0;
            withdrawalLimit = SAVINGS_WITHDRAWAL_LIMIT;
        }
        inTheRed = (currentBalance < minBalance);

    }


    // Getters
    public double getBalance(){
        return currentBalance;
    }

    public AccountType getAccount() {
        return account;
    }

    public String getAccountID(){
        return id;
    }

    public double getMinBalance(){
        return minBalance;
    }

    // withdrawal method
    public boolean withdraw(double amount) {
        if (inTheRed) {
            System.out.println("Withdrawal unsuccessful,account in red");
            return false;
        }

        if (withdrawalLimit != -1 && numWithdrawalCB >= withdrawalLimit) {
            System.out.println("Withdrawal unsuccessful,withdrawal limit exceeded");
            return false;
        }
        if (currentBalance - amount < minBalance) {
            System.out.println("Withdrawal unsuccessful,Insufficient balance");
            return false;
        }

        currentBalance -= amount;
        numWithdrawalCB++;
        System.out.println("\nTransaction Successful");
        return true;
    }

    public void deposit(double amount){
        currentBalance += amount;
        }


        //Maintenance method
    public void performMonthlyMaintenance(){
        double Interest = (currentBalance *interestRate * (1.0/12.0))/100.0;
        currentBalance+= Interest;
        currentBalance-= maintenance;
        inTheRed = (currentBalance < minBalance);
        numWithdrawalCB = 0;
        System.out.printf("%nEarned interest: %.2f%nMaintenance fee: %.2f%nUpdated balance: %.2f", Interest,maintenance,currentBalance);

        if (inTheRed){
            System.out.println("WARNING: This account is in red");
        }

    }
    //transactions between accounts
    public boolean transfer(boolean transferTo, BankAccount otherAccount, double amount){
        // from this account to other
        if (transferTo){
            if (withdraw(amount)){
                otherAccount.deposit(amount);
                return true;
            }
            else {
                return false;
            }

        }
        // from other account to this
        else{
            if(otherAccount.withdraw(amount)){
                deposit(amount);
                return true;
            }
            else {
                return false;
            }
        }




    }














    }

