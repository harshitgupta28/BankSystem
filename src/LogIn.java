import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

 class LogIn implements Customer  {




    private int accountno;
    private int password;

 public String login(){
      Scanner input=new Scanner(System.in);
      System.out.println("please enter your account number");
      do{
          this.accountno=input.nextInt();
          if(accountno>999999){
              System.out.println("try again");
          }
      }while(accountno>=999999);

      System.out.println("please enter password");

this.password= input.nextInt();

String s1=accountno+","+password;
return s1;


  }

     @Override
     public String SignIn() {
Scanner input1=new Scanner(System.in);
         int acc;
         System.out.println("enter your username");
         String name=input1.nextLine();
         do {
             System.out.println("enter account number");
              acc = input1.nextInt();
         }while(acc>999999);
         System.out.println("please enter password");
         int pass= input1.nextInt();

         String output=acc+","+pass+","+name;





         return output;//account no password name
     }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
     @Override
     public int deposit() {
         System.out.println("please tell the amount to be deposited");
         Scanner credit=new Scanner(System.in);
         int positive= credit.nextInt();
return positive;

     }

     @Override
     public int withdraw() {
         System.out.println("please tell the amount to be withdraw");
         Scanner credit=new Scanner(System.in);
         int negative=1;
         while(negative <= 1) {
             System.out.println("ammount more than 1$ ");
            negative = credit.nextInt();
         }
         return negative;

     }

     @Override
     public void show_cash() {

         System.out.println("press here to see cash");

     }

     @Override
     public String transferMoney() {

         System.out.println("please enter the account where u want to send money");

         Scanner input
                 =new Scanner(System.in);

         int account=input.nextInt();

         System.out.println("amount to transfer");

         int money=input.nextInt();

         String data=account+","+money;







         return data;
     }
//////////////////////////////////////////////////////////////////////////////////////////////////////////







 }

