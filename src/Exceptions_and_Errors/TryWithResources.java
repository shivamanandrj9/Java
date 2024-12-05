package Exceptions_and_Errors;

import java.io.BufferedReader;
import java.io.FileReader;

public class TryWithResources {
    public static void main(String[] args) {
        //The objects that are auto closable, we can use try with resources. It will automatically close this object once its work is done.
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader("Hello.txt"))){
            String line;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
