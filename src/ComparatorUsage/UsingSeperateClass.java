package ComparatorUsage;

import java.util.*;

public class UsingSeperateClass {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> x=new ArrayList<>();
        Random rand=new Random();
        for(int i=0;i<3;i++)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(rand.nextInt(10));
            temp.add(rand.nextInt(10));
            temp.add(rand.nextInt(10));
            x.add(temp);
        }


        Collections.sort(x, new MyComparator());

        for(int i=0;i<x.size();i++)
        {
            System.out.println(x.get(i));
        }
    }
}

class MyComparator implements Comparator<ArrayList<Integer>>{

    @Override
    public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i)<b.get(i))
            {
                return -1;
            }
            else if(a.get(i)>b.get(i))
            {
                return 1;
            }
        }
        return 0;
    }

}
