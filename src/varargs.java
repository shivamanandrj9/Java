



public class varargs {
    public static void main(String[] args) {
        System.out.println(doSum(1,2,3,4,5,6));

        System.out.println(doSumWithAtLeastOneArg(5,1,2,3,4,5));
    }

    static int doSum(int ...arr)
    {
        int result=0;
        for(int x:arr)
        {
            result+=x;
        }
        return result;
    }

    //for atleast one argument

    static int doSumWithAtLeastOneArg(int x,int ...arr){
        int result=x;
        for(int p:arr)
        {
            result+=p;
        }
        return result;
    }
}
