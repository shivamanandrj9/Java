package Exceptions_and_Errors;

public class FinallyInTryCatchBlock {
    public static void main(String[] args) {
        System.out.println(divide(5,0));
    }

    public static int divide(int a,int b){

        try{
            return a/b;
        }
        catch(ArithmeticException e){

            System.out.println("Arithmetic Exception"+e);
            return -1;
        }
        finally{
            //ye wala block chalega hi chalega uske baad hi return karne se pehle.
            System.out.println("Finally Block");
        }
    }

}
