package Exceptions_and_Errors;

public class del {

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {

        int[] arr=new int[5];
        arr[0]=0;
        arr[1]=-1;
        arr[2]=1;
        for(int i=0;i<5;i++)
        {
            try{
                System.out.println(arr[arr[i]]);
            }catch(RuntimeException e){
                System.out.println(e);
            }
        }
    }


}
