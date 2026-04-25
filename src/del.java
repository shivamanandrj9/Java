import java.util.*;

public class del{
    public static void main(String[] args) {
        Pair<Integer, Integer> p1=new Pair<>(10,3);
        Pair<Integer, Integer> p2=new Pair<>(5,6);

        List<Pair<Integer,Integer>> ls=new ArrayList<>();
        ls.add(p1);
        ls.add(p2);

        Collections.sort(ls, new PairComparator());
        System.out.println(ls.get(0).getKey());
    }




}

class Pair<K,V>{
    K key;
    V value;

    Pair (K key, V value){
        this.key=key;
        this.value=value;
    }

    K getKey(){
        return this.key;
    }

    V getValue(){
        return this.value;
    }
}

class PairComparator implements Comparator<Pair<Integer,Integer>> {

    @Override
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        if(o1.getKey()<o2.getKey()){
            return -1;
        }
        else if(o1.getKey()==o2.getKey()){
            if(o1.getValue()<=o2.getValue()){
                return -1;
            } else {
                return 1;
            }
        } else{
            return 1;
        }
    }
}



