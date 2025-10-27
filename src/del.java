import java.util.*;

public class del{
    public static void main(String[] args) {
            Node<Integer> head=new Node<>(5);
            addNode(new Node<Integer>(10),head);
            addNode(new Node<Integer>(15),head);

            print(head);
    }

    static void addNode(Node node, Node head){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }

    static void print(Node head){
        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }


}

class Node<T>{
    T value;
    Node next;

    Node(T val){
      this.value=val;
      this.next=null;
    }
}



