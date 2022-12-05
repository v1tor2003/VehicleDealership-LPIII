package ds.queue;

import ds.singlyll.SinglyLinkedList;

public class Queue<T> extends SinglyLinkedList<T>{
  
  public Queue(){
    super();
  }

  public void enQueue(T newElement){
    super.insertAtEnd(newElement);
  }

  public T deQueue(){
    return super.removeFromStart().getData();
  }
  
  @Override
  public String toString(){
    return "Queue: \n" + super.toString();
  }
}
