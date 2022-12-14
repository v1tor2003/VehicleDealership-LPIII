package ds.dsinterfaces;

public interface QueueI<T> {
  @Override
  String toString();
  void enQueue(T obj);
  T deQueue();
}
