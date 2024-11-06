
/*

Time Complexities:

push -> O(1)
pop -> O(1)
peek -> O(1)

Normal array operations

 */



package Collections;

import java.util.*;

public class Stack_in_java {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<Integer>();


        //pushing an element

        st.push(5);
        st.push(6);
        st.push(10);
        st.push(15);



        //poping an element

        st.pop();

        //checking the top element of the stack

        System.out.println(st.peek());



        //printing the whole stack

        System.out.println(st);


        //taking out elements one by one

        while(!st.empty())
        {
            System.out.println(st.peek());
            st.pop();
        }


    }
}
