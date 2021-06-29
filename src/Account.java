import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    //var declare
    private int customerNumber;
    private int pinNumber;
    private double currentBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    //create methods for options for operate account
    public int setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber(){
        return customerNumber;
    }

    public int setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber(){
        return pinNumber;
    }

    public double  getCurrentBalance(){
        return currentBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public double calcCurrentWithdraw(double amount){
        currentBalance = (currentBalance - amount);
        return currentBalance;
    }

    public double calcSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calcCurrentDeposit(double amount){
        currentBalance = (currentBalance + amount);
        return currentBalance;
    }

    public double calcSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void getCurrentWithdrawInput(){
        System.out.println("Current Account Balance: "+moneyFormat.format(currentBalance));
        System.out.println("Amount you want to withdraw from current Account: ");
        double amount = input.nextDouble();

        if((currentBalance - amount) >= 0){
            calcCurrentWithdraw(amount);
            System.out.println("New Current Account Balance: "+ moneyFormat.format(currentBalance));
        }else{
            System.out.println("Balance Cannot Withdraw"+"\n");
        }
    }

    public void getCurrentDepositInput(){
        System.out.println("Current Account Balance: "+moneyFormat.format(currentBalance));
        System.out.println("Amount you want to Deposit in to current Account: ");
        double amount = input.nextDouble();

        if((currentBalance + amount) >= 0){
            calcCurrentDeposit(amount);
            System.out.println("New Current Account Balance: "+ moneyFormat.format(currentBalance));
        }else{
            System.out.println("Balance Cannot be Negative"+"\n");
        }
    }

    public void getSavingWithdrawInput(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw from saving Account: ");
        double amount =input.nextDouble();

        if((savingBalance-amount)>=0){
            calcSavingWithdraw(amount);
            System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));
        }else{
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }

    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to Deposit from saving Account: ");
        double amount =input.nextDouble();

        if((savingBalance+amount)>=0){
            calcSavingDeposit(amount);
            System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));
        }else{
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }
}
