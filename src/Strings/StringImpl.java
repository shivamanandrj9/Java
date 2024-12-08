package Strings;

public class StringImpl {

    public static void main(String[] args) {

        String s="Abcdef";
        s="ghij"; //s is now pointing to "ghij" and "Abcdef" is still in the memory.

        //fetching some info from the string
        int len=s.length();
        char x=s.charAt(1);
        int index=s.indexOf("ij"); //if it does not exist then -1
        String sub=s.substring(1,3);
        System.out.println(sub);

        //we cannot modify the actual string. Any operation we do, we need to store the new string in a seperate string or point the s to that new string

        s=s+"hue"; //new string in the memory is created i.e "ghijhue" and s is now pointing to that
        s=s.toUpperCase();
        s=s.replace("hue","pue"); //all occurence of hue is replaced by pue.

        //remove karne ka koi direct command nahi hai. For loop chala sakte hain aur naya string str bana ke usme + " " kar sakte hain. But wo har prefix ke liye ek naya string banaega heap me. So, it is not efficient.



        System.out.println(s);
    }
}
