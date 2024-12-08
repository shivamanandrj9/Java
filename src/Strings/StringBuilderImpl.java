package Strings;

public class StringBuilderImpl {
    public static void main(String[] args) {

        //creating a string
        StringBuilder sb=new StringBuilder("Shivam");

        //appending another string. Time Complexity: O(n), where n is the length of the string to be appended
        sb.append(" Anand");

        //removing only the last character of a string. time complexity: O(1)
        sb.delete(sb.length()-1,sb.length()-1);

        //inserting a character at a particular index. Time complexity: O(n)
        sb.insert(1,"h");

        //reversing a string. Time complexity: O(n)
        sb.reverse();

        StringBuilder newsb=sb;
        newsb.append(" is");

        for(int i=0;i<sb.length();i++)
        {
            System.out.print(sb.charAt(i));
        }


    }
}
