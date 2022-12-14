package ds.dsinterfaces;

import ds.singlyll.SinglyLinkedList.Node;

public interface SinglyListI<T>{
  @Override
  String toString();
  int size();
  boolean contains(T obj);
  boolean isEmpty();
  Node<T> first();
  Node<T> last();
  void insertAtStart(T obj);
  void insertAfter(T ref, T obj);
  void insertAtEnd(T obj);
  Node<T> remove(T reference);
  Node<T> removeFromStart();
  Node<T> removeAfter(T reference);
  Node<T> removeFromEnd(); 
}
