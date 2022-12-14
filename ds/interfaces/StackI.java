package ds.interfaces;

public interface StackI<T> {
  @Override
  String toString();
  void push(T obj);
  T pop();
  T peek();
}
