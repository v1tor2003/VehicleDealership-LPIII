package ds.queue;

import ds.list.List;

public class Queue<T> extends List<T>{
  
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
