import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class BankServer implements BankSystem {
    String account;
    String password1;
    String account_path;
    public static int a = 0;


    @Override
    public String verify(String DataToCheck) {

        //account no password
        String[] s5 = DataToCheck.split(",");
        String accountToCheck = s5[0];
        String passwordToCheck = s5[1];

        int i = 0;
        try {

            BufferedReader o1 = new BufferedReader(new FileReader("C:\\Users\\Bhavuk\\Desktop\\test\\account.txt"));
            String s1;

            while ((s1 = o1.readLine()) != null && i != 1) {

                String[] s2 = s1.split(",");

                if (accountToCheck.equals(s2[0])) {
                    System.out.println("account no is correct");
                    this.account = s2[0];
                    System.out.println(s2[0]);
                    System.out.println(s2[2]+"cfgvhbjnkml");
                    i = 1;

                    if (passwordToCheck.equals(s2[1])) {
                        this.password1 = s2[1];
                        System.out.println("log in is succesful");

                        return s2[3];

                    } else {
                        System.out.println("password is wrong");
                        System.out.println(s2[1]);
                        return null;
                    }

                }


            }


        } catch (Exception ex) {

        }
        return null;

    }

    @Override
    public boolean CreatingAccount(String ss1) {


        try {

            //ss1 acc pass username
            BufferedReader o1 = new BufferedReader(new FileReader("C:\\Users\\Bhavuk\\Desktop\\test\\account.txt"));
            String reader;
            String[] Spplit=ss1.split(",");
            int i=0;

     String account=       Spplit[0];

            while((reader=o1.readLine())!=null){

                String[] Sp1=reader.split(",");
                if(account.equals(Sp1[0])){
                    i=1;
                    System.out.println("account already exist");
                    return true;
                }


            }
o1.close();



    BufferedWriter o5 = new BufferedWriter(new FileWriter("C:\\Users\\Bhavuk\\Desktop\\test\\account.txt", true));
    String path = ss1+","+"C:\\Users\\Bhavuk\\Desktop\\test\\" + account + ".txt";
            System.out.println(path);
    o5.write(path+"\n");
    File new1=new File(path);
    o5.close();
    return false;




        } catch (Exception ex) {
            System.out.println("System error");
            return true;

        }


    }

    @Override
    public void deposit(int credit, String path) {
        try {
//path account path
            System.out.println(path + " " + credit);
            BufferedWriter o1 = new BufferedWriter(new FileWriter(path, true));

            o1.write( credit+",");
            o1.close();
            System.out.println("done");

        } catch (Exception ex) {


            System.out.println("file was not found");
        }


    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public boolean withdraw(int debit, String path) {


      try {
          int TotalBalanace=  totalAmount(path, debit);
          System.out.println(TotalBalanace);


          BufferedWriter o3 = new BufferedWriter(new FileWriter( path, true));

           if(debit<=TotalBalanace ){
              int negativedebt=~(debit-1);

String s1=negativedebt+",";

o3.write(s1);
o3.close();
               int balance=TotalBalanace-debit;
               System.out.println("done");
return true;
          }else{
               System.out.println("insufficient balance");
return false;
           }


      }catch(Exception ex){

          System.out.println("file not found");
          return false;
      }


    }

    @Override
    public int show(String path) {

        int Total=totalAmount(path,-1);


        return Total;
    }

    @Override
    public int tranfermoney(String path, String data) {

        String[]s1=data.split(",");

String path11 = null;
        String account_no=s1[0];
        int money=Integer.parseInt(s1[1]);
        try {

            BufferedReader o1 = new BufferedReader(new FileReader("C:\\Users\\Bhavuk\\Desktop\\test\\account.txt"));

String reader;
int i=0;

            while((reader=o1.readLine())!=null&&i==0){

                String[] Sp1=reader.split(",");

                if(account_no.equals(Sp1[0])){
                    path11=Sp1[3];

               boolean result=     withdraw(money,path);
                    if(result==true)
                    deposit(money,path11);


                    i=1;
                }


                }


            System.out.println("account not found");



        }catch(Exception ex){

        }


        return 0;
    }


    private int totalAmount(String path, int debit) {
        try {
            System.out.println(path);

            BufferedReader o1 = new BufferedReader(new FileReader(path));
            String read;
            int total = 0;


            while ((read = o1.readLine()) != null) {

                String[] Number = read.split(",");

                for (int i = 0; i < Number.length; i++) {

                    String s1=Number[i];
                    //error
                    int number1=Integer.parseInt(s1);

                    total = total + number1;



                }


            }


            if (debit <= total) {

                return total;
            } else {

                return 0;
            }


        } catch (Exception ex) {

            System.out.println("file not found");

            return 0;
        }

    }

}



