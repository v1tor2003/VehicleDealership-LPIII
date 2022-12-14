package ds.queue;

import ds.dsinterfaces.QueueI;
import ds.singlyll.SinglyLinkedList;

public class Queue<T> extends SinglyLinkedList<T> implements QueueI<T>{
  
  public Queue(){
    super();
  }

  @Override
  public void enQueue(T newElement){
    // TODO Auto-generated method stub
    super.insertAtEnd(newElement);
  }

  @Override
  public T deQueue(){
    // TODO Auto-generated method stub
    return super.removeFromStart().getData();
  }
  
  @Override
  public String toString(){
    if(isEmpty())
      return "Queue Is Empty"; 

    return "Queue: \n" + super.toString();
  }
}
