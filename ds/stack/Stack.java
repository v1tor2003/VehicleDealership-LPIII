package ds.stack;

import ds.dsinterfaces.StackI;
import ds.singlyll.SinglyLinkedList;

public class Stack<T> extends SinglyLinkedList<T> implements StackI<T>{
  
  public Stack(){
    super();
  }

  @Override
  public void push(T newElement){
    // TODO Auto-generated method stub
    super.insertAtStart(newElement);
  }

  @Override
  public T pop(){
    // TODO Auto-generated method stub
    return super.removeFromStart().getData();
  }

  @Override
  public T peek(){
    // TODO Auto-generated method stub
    Node<T> temp = super.removeFromStart();
    push(temp.getData());
    return temp.getData();
  }

  @Override
  public boolean contains(T ref){
    return super.contains(ref);
  }

  @Override
  public String toString(){
    return "Stack: \n" + super.toString();
  }
}
