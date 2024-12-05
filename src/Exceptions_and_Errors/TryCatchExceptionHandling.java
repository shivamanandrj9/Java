package Exceptions_and_Errors;

public class TryCatchExceptionHandling {

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int[] dens={1,0,2,3};

        for(int i=0;i<6;i++)
        {
            try{
                int ans=nums[i]/dens[i];
            }
            catch(ArithmeticException e) //we can also use or operator | to catch multiple exceptions
            {
                System.out.println("Arithmetic Exception"+e);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Array Index Out of Bound Exception"+e);
            }
            catch(Exception e)
            {
                System.out.println("Some Other Exception"+e);
            }
        }
    }


}
