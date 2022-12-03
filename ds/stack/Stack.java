package ds.stack;

import ds.list.List;

public class Stack<T> extends List<T> {
  
  public Stack(){
    super();
  }

  public void push(T newElement){
    super.insertAtStart(newElement);
  }

  public T pop(){
    return super.removeFromStart().getData();
  }

  public T peek(){
    Node<T> temp = super.removeFromStart();
    push(temp.getData());
    return temp.getData();
  }

  @Override
  public String toString(){
    return "Stack: \n" + super.toString();
  }
}
