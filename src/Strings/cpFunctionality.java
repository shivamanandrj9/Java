/*
The following functionality that we use in c++.

1) string s="abcd" -> StringBuilder s=new StringBuilder("abcd");
2) if(s=="abcd") -> if(s.toString().equals("abcd"));
3) s.size() -> s.length();
4) reverse(s.begin(),s.end()) -> s=s.reverse();
3) s.push_back('a') -> s.append('a');
4) s.pop_back() -> s.deleteCharAt(s.length()-1);
5) string p=s -> StringBuilder p=new StringBuilder(s);
6) string x=to_string(456) -> StringBuider x=new StringBuilder(Integer.toString(456));
7) Integer n=stoi(s) -> int n=Integer.parseInt(s);
8) s.clear() -> s.setLength(0);
9) s.substr(1,2) -> s.substring(1,3);
10) if(a<b) -> if(x.compareTo(y)), here x and y both are StringBuilder objects and it will return negative if(x<y) , 0 for same and positive for more

 */

package Strings;

public class cpFunctionality {
}
