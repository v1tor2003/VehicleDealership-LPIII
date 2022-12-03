package ds.list;

public class List<T> {
  
  protected static class Node<T> {
    private T data;
    private Node<T> next;
  
    Node(T obj){
      this.data = obj;
      this.next = null;
    }

    public String toString(){
      return String.format("%s", this.data);
    }

    public T getData(){
      return data;
    }
  }

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public List(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public int size(){
    return this.size;
  }

  public boolean contains(T node){
    Node<T> testNode = findNode(this.head, node);
    
    return testNode != null;
  }

  private boolean isEmpty() {
    
    return this.head == null;
  }

  protected String first(){
    return this.head.toString();
  }

  protected String last(){
    return this.tail.toString();
  }

  protected void insertAtStart(T data) {
    
    Node<T> newNode = createNode(data);
    
    if(isEmpty()){
      this.head = newNode;
      this.tail = this.head;
    }else{
      newNode.next = this.head;
      this.head = newNode;
    }

    this.size++;
  }

  protected void insertAfter(T reference, T data) {
    
    Node<T> newNode = createNode(data);
    Node<T> placeToInsert;  
    
    if(!isEmpty()){
      placeToInsert = findNode(this.head, reference);
      newNode.next = placeToInsert.next;
      placeToInsert.next = newNode;
    }else
      this.head = newNode;
    
    this.size++;
  }

  protected void insertAtEnd(T data) {
    
    Node<T> newNode = createNode(data);
    
    if(isEmpty()){
      this.head = newNode;
      this.tail = this.head;
    }else{
      this.tail.next = newNode;
      this.tail = newNode;
    }

    this.size++;
  }
  
  protected Node<T> findNode(Node<T> start, T reference) {
    
    if(start == null)
      return null;
    
    if((start.data.equals(reference)))
      return start;

    return findNode(start.next, reference);
  }

  private Node<T> createNode(T data) {
    
    Node<T> node = new Node<T>(data);

    return node;
  }

  public void clear(){
    this.head = null;
    this.size = 0;
  }

  private Node<T> beforeEnd(Node<T> start){
    if(start.next == this.tail)
      return start;
    
    return beforeEnd(start.next);
  }

  protected Node<T> removeFromStart() {
    
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }
    
    Node<T> temp = this.head;
    this.head = temp.next;
    temp.next = null;
    
    if(isEmpty())
      this.tail = this.head;
    
    this.size--;
    return temp;
  }
  
  protected Node<T> removeAfter(T reference) {
    
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }

    Node<T> placeToRemove = findNode(head, reference);
    
    if(placeToRemove.next == null)
      return null;
    
    Node<T> temp = placeToRemove.next;
    placeToRemove.next = temp.next;
    
    this.size--;
    return temp;
  }

  private Node<T> findBeforeNode(Node<T> start, T reference){
    if(start.next == null || start.next.data.equals(reference))
      return start;

    return findBeforeNode(start.next, reference);
  }

  protected Node<T> removeFromEnd() {
    
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }
    
    this.size--;

    if(this.head == this.tail){
      Node<T> temp = this.head;
      this.head = null;
      this.tail = null;
      return temp;
    }

    Node<T> previousEnd = beforeEnd(this.head);
    Node<T> end = previousEnd.next;
    
    previousEnd.next = null;
    this.tail = previousEnd;
    
    return end;
  }

  protected Node<T> remove(T reference){
    if(this.head.data.equals(reference))
      return removeFromStart();
    else if(this.tail.data.equals(reference))
      return removeFromEnd();
    
    Node <T> beforeRef = findBeforeNode(head, reference);
    return removeAfter(beforeRef.data);
  }

  public String toString(){
    if(isEmpty())
      return "List is empty";
    else{
      Node<T> currentNode = this.head;
      String list = "";
      while(currentNode.next != null){
        list += currentNode + "\n";
        currentNode = currentNode.next;
      }
      list += currentNode;
      return list;
    }
  }
}

