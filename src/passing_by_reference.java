public class passing_by_reference {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
    }

    static void change(int []arr){
        arr[0]=15;
    }
}
