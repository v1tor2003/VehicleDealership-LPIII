package ds.dsinterfaces;

public interface StackI<T> {
  @Override
  String toString();
  void push(T obj);
  T pop();
  T peek();
  boolean contains(T obj);
}
