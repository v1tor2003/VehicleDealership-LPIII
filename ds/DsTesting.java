package ds;

import ds.queue.Queue;
import ds.singlyll.SinglyLinkedList;
import ds.stack.Stack;

public class DsTesting {
  public static void main(String[] args) {
    SinglyLinkedList<String> list = new SinglyLinkedList<String>();

    list.insertAtStart("1");
    list.insertAtEnd("X");
    list.insertAfter("1","Before X");

    System.out.println(list.toString());

    System.out.println("Contains? "+ list.contains("1"));
    System.out.println("first: "+ list.first());
    System.out.println("last: "+ list.last());

    System.out.println("Node from start: "+ list.removeFromStart());
    System.out.println("Node from end: "+ list.removeFromEnd());

    System.out.println("remove: " + list.remove("Before X"));
    System.out.println(list.toString());

    System.out.println("Testing Stack");
    Stack<String> pila = new Stack<>();
    Stack<String> pila1 = new Stack<>();
    

    pila.push("p1");
    pila.push("p2");
    pila.push("p3");

    pila.peek();
    
    System.out.println(pila.toString());

    pila1.push(pila.pop());

    System.out.println(pila1.toString());
    System.out.println(pila.size());
    System.out.println(pila1.size());

    Queue<Float> fila = new Queue<>();
    Queue<Float> fila1 = new Queue<>();

    fila.enQueue(2.0f);
    fila.enQueue(2.2f);
    fila.enQueue(2.5f);
    
    System.out.println(fila.toString());

    fila1.enQueue(fila.deQueue());
    fila1.enQueue(fila.deQueue());

    System.out.println(fila.toString());
    System.out.println(fila1.toString());


  }
}
