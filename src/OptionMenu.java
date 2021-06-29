import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException{
        int x = 1;
        do{
            try{
                data.put(952141, 191904);
                data.put(989947, 71976);

                System.out.println("Welcome to the ATM");
                System.out.println("Enter your customer Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your pin number: ");
                setPinNumber(menuInput.nextInt());
            }catch (Exception e){
                System.out.println("\n"+"Invalid Character(s). Only Numbers."+"\n");
                x = 2;
            }

            /*for (Map.Entry<Integer, Integer> it: data.entrySet()){
                if(it.getKey() == getCustomerNumber() && it.getValue()==getPinNumber()){
                    getAccountType();
                }
            }*/

            int cn = getCustomerNumber();
            int pn = getPinNumber();

            if(data.containsKey(cn) && data.get(cn) == pn){
                getAccountType();
            }else{
                System.out.println("\n"+"wrong Customer Number or Pin Number" + "\n");
                System.out.println("\n" + "If you Don't have Account please create Account"+"\n");
                System.out.println("Enter your customer Number ");
                int cst_no = menuInput.nextInt();
                System.out.println("Enter PIN to be register");
                int pin = menuInput.nextInt();
                data.put(cst_no,pin);
                System.out.println("Your new account has been Successfully Registered! ");
                System.out.println("Redirecting to login......");
                getLogin();
            }
        }while(x == 1);
    }

    public void getAccountType(){
        System.out.println("Select the account you want to access: ");
        System.out.println(" Type 1 - current account");
        System.out.println(" Type 2 - Saving Account");
        System.out.println(" Type 3 - Exit");

        int selectOption = menuInput.nextInt();
        switch (selectOption){
            case 1:
                getCurrent();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using Our ATM Service, Bye \n");
                break;

            default:
                System.out.println("\n"+"Invalid Choice."+"\n");
                getAccountType();
        }
    }

    public void getCurrent(){
        System.out.println("Current account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
        System.out.println(" Type 5 - Back to Main Menu");
        System.out.print(" Type 2 - Enter your Choice: ");

        int selectOption = menuInput.nextInt();

        switch(selectOption){
            case 1:
                System.out.println("Current Account Balance: "+moneyFormat.format(getCurrentBalance()));
                getCurrent();
                break;

            case 2:
                getCurrentWithdrawInput();
                getCurrent();
                break;

            case 3:
                getCurrentDepositInput();
                getCurrent();
                break;

            case 4:
                System.out.println("Thank you for using our ATM service, Bye \n");
                break;

            case 5:
                getAccountType();
                break;

            default:
                System.out.println("\n"+"Invalid Choice"+"\n");
                getCurrent();
        }
    }

    public void getSaving(){
        System.out.println("Saving account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
        System.out.println(" Type 5 - Back to Main Menu");
        System.out.print(" Type 2 - Enter your Choice: ");

        int selectOption = menuInput.nextInt();

        switch(selectOption){
            case 1:
                System.out.println("Saving Account Balance: "+moneyFormat.format(getSavingBalance()));
                getSaving();
                break;

            case 2:
                getSavingWithdrawInput();
                getSaving();
                break;

            case 3:
                getSavingDepositInput();
                getSaving();
                break;

            case 4:
                System.out.println("Thank you for using our ATM service, Bye \n");
                break;

            case 5:
                getAccountType();
                break;

            default:
                System.out.println("\n"+"Invalid Choice"+"\n");
                getSaving();
        }
    }
}
