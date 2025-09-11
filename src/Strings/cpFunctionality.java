/*
The following functionality that we use in c++.

// C++                            | Java
// -----------------------------| --------------------------------------------
0) char x=s[0];                 | char x=s.charAt(0);
1) string s = "abcd";           | StringBuilder s = new StringBuilder("abcd");
2) if(s == "abcd")              | if(s.toString().equals("abcd"));
3) s.size()                     | s.length();
4) reverse(s.begin(), s.end()); | s = s.reverse();
5) s.push_back('a');            | s.append('a'); or s.insert(s.length(),"a");
6) s.pop_back();                | s.deleteCharAt(s.length() - 1); or s.delete(s.length()-1,s.length);
7) string p = s;                | StringBuilder p = new StringBuilder(s);
8) string x = to_string(456);   | StringBuilder x = new StringBuilder(Integer.toString(456));
9) int n = stoi(s);             | int n = Integer.parseInt(s);
10) s.clear();                  | s.setLength(0);
11) s.substr(1, 2);             | s.substring(1, 3);
12) if(a<b)                     | if(x.compareTo(y)), here x and y both are StringBuilder objects and it will return negative if(x<y) , 0 for same and positive for more

 */

package Strings;

public class cpFunctionality {

    //sorting a string

}
