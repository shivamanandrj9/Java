package MapsInJava;

import java.util.TreeMap;

public class cpUsage {

    public static void main(String[] args) {
        TreeMap<Integer,Integer> mp=new TreeMap<>();
        mp.put(5,mp.getOrDefault(5,0)+1); //this will be similar to mp[5]++;
    }


}
