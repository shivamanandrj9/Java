import java.util.*;

public class del{
    public static void main(String[] args) {
        color myfavcolor=color.RED;
        System.out.println(color.RED.HindiName);


    }


}

enum color{
    RED("Laal"),BLUE("Neela"),GREEN("Hara");

    public String HindiName;

    color(String giveName){
        this.HindiName=giveName;
    }

}

