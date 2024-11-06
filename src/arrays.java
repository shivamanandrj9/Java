public class arrays {
    public static void main(String[] args) {
        int[] marks=new int[5];
        System.out.println(marks);

        int[] allocation={1,2,3,4,5};


        //multidimensional aray

        int[][] dp=new int[10][10];
        for(int i=0;i<10;i++)
        {
            System.out.println(i);
            for(int j=0;j<10;j++)
            {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }
}


