package ds.heap;

public class Heap<T extends Comparable<T>>{
  private T[] vector;
  private int size;

  public Heap(int size){
    this.size=size;
    this.vector=(T[]) new Comparable[size];     
  }

  public T[] getVector(){
    return this.vector;
  }
  
  public int getSize(){
    return this.size;
  }

  static int parent(int index) {
    return (index-1)/ 2;
  }

  static int leftChild(int index) {
    return (2 *index)+1;
  }

  static int rightChild(int index) {
    return (2 * index) + 2;
  }

  private void swap(int index1, int index2) {
    T tmp;
    tmp = this.vector[index1];
    this.vector[index1] = this.vector[index2];
    this.vector[index2] = tmp;
    }

  private void downHeap(int index) {
    if (index >= (size / 2) && index <= size)
        return;

    if (vector[index].compareTo(vector[leftChild(index)])==1||vector[index].compareTo(vector[leftChild(index)])==1) {
      if (vector[leftChild(index)].compareTo(vector[rightChild(index)])==1){
        swap(index, leftChild(index));
        downHeap(leftChild(index));
      } else {
          swap(index, rightChild(index));
          downHeap(rightChild(index));
      }
    }
  }
  private void upHeap(int index) {
    T temp = vector[index];
    while(index>0 && temp.compareTo(vector[parent(index)])==-1){
        vector[index] = vector[parent(index)];
        index = parent(index);
    }
    vector[index] = temp;
  }

  public void insert(T element) {
    this.vector[size] = element;//inicia do 0
    int current = size;//chama up heap a partir do elemento inserido
    upHeap(current);

  }
}
