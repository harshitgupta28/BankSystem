import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("welcome to banking system ");

        LogIn o1 = new LogIn();
        BankServer o2 = new BankServer();
        boolean a = true;


        String path = null;
        do {
            System.out.println("press 2 to log in");
            System.out.println("** if u dont have a id create one by pressing 1");
            Scanner input11 = new Scanner(System.in);//taking the number
            int in = input11.nextInt();

            if (in == 2) {
                String acc_pass = o1.login();
                path = o2.verify(acc_pass);
            }

            if (in == 1) {

                String path1 = o1.SignIn();
                a = o2.CreatingAccount(path1);
                if (a == true) {
                    System.out.println("new account is not made");
                } else {

                    System.out.println("account is made please login");

                }

            }


            if (path == null && in != 2)
                System.out.println("incorrect account or password");


        } while (path == null);
        while(true) {
            System.out.println("press 1 to deposit");

            System.out.println("press 2 to withdraw");

            System.out.println("press 3 to check statment");
            System.out.println("press 4 to transfer money to another account");

            Scanner input = new Scanner(System.in);
            int input1 = input.nextInt();
            switch (input1) {
                case 1:
                    int credit = o1.deposit();
                    o2.deposit(credit, path);
                    break;
                case 2:
                    int debit = o1.withdraw();
                    o2.withdraw(debit, path);

                    break;
                case 3:
                    o1.show_cash();
                    System.out.println(o2.show(path));
                    break;
                case 4:
                 String data=   o1.transferMoney();
o2.tranfermoney(path,data);


            }


        }


    }

}

