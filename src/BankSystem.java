interface BankSystem {


   String verify(String acc);
   boolean CreatingAccount(String ss1);
   void deposit(int credit,String path);
   boolean withdraw(int debit,String path);
   int  show(String path);
   int tranfermoney(String path,String data);



}
