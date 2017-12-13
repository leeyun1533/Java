package testWindowBulider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class AccountManager {
    private static final File dataFile= new File("Account.dat");
    public static ArrayList<Account> accountStorage = new ArrayList<>();
    public static AccountManager inst=null;

    public static AccountManager createManagerInst(){
        if(inst==null)
            inst = new AccountManager();
        return inst;
    }

    public AccountManager(){
        readFromFile();
    }

    public void readFromFile()
    {
        if(!dataFile.exists())

            return;
        try{
            FileInputStream file = new FileInputStream(dataFile);
            ObjectInputStream in = new ObjectInputStream(file);
            while (true){
                Account ac = (Account)in.readObject();
                if(ac==null)
                    break;
                accountStorage.add(ac);
            }
            in.close();
        }catch (IOException e){
            return;
        }catch (ClassNotFoundException e){
            return;
        }
    }

    public static void storeToFile()
    {
        try{
            FileOutputStream file=new FileOutputStream(dataFile);
            ObjectOutputStream out=new ObjectOutputStream(file);

            for (Account anAccountStorage : accountStorage)
                 out.writeObject(anAccountStorage);
            out.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
