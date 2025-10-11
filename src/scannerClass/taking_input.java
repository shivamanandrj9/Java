package scannerClass;

import java.util.Scanner;

public class taking_input {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        int a=sc.nextInt();
        System.out.println(a);


        float b=sc.nextFloat();
        System.out.println(b);


        //if we give input "ram is a good boy" to c then it will just take away "ram" and then leave " is a good boy" in the buffer which is taken by d. So be careful
        String c=sc.next(); //will take only a single word
        System.out.println(c);


        String d=sc.nextLine(); //will take whole sentance
        System.out.println(d);



    }
}
