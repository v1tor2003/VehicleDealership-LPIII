package ds.tree;

public class Tree<T extends Comparable<T>> {
  private Node<T> root;

  public Tree() {
    this.root = null;
  }

  public Tree(T value) {
    insertBT(this.root, value);
  }

  public Node<T> getRoot() {
    return root;
  }

    public void insertBT(Node<T> currentNode, T value){
        if(this.root == null)
            root = new Node<T>(value);
        else if (currentNode.getKey().compareTo(value) == 1){
            if(currentNode.getLeft() == null){
                Node<T> newNode = new Node<T>(value);
                currentNode.setLeft(newNode);
            }else{
                insertBT(currentNode.getLeft(), value);
            }
        }else{
            if (currentNode.getRight() == null){
                Node<T> newNode = new Node<T>(value);
                currentNode.setRight(newNode);
            }else{
                insertBT(currentNode.getRight(), value);
            }
        }
    }

    protected void printPreOrder(Node<T> currentNode) {
        System.out.println(" " + currentNode.getKey());
        if(currentNode.getLeft() != null){
            printPreOrder(currentNode.getLeft());
        }
        if(currentNode.getRight() != null){
            printPreOrder(currentNode.getRight());
        }
    }

    protected void printInOrder(Node<T> currentNode) {
        if (currentNode.getLeft() != null) {
            printInOrder(currentNode.getLeft());
        }

        System.out.println(" " + currentNode.getKey());

        if (currentNode.getRight() != null) {
            printInOrder(currentNode.getRight());
        }
    }

    protected void printPosOrder(Node<T> currentNode) {
        if (currentNode.getLeft() != null) {
            printPosOrder(currentNode.getLeft());
        }

        if (currentNode.getRight() != null) {
            printPosOrder(currentNode.getRight());
        }

        System.out.println(" " + currentNode.getKey());
    }

    public void printTree(Node<T> currentNode) {
        printInOrder(currentNode);
    }

    public T FindValue(Node<T> currentNode, T value) {
        if (currentNode.getKey().equals(value)) {
            return currentNode.getKey();
        } else if (currentNode.getKey().compareTo(value) == 1) {
            if (currentNode.getLeft() == null) {
                return null;
            } else {
                return (FindValue(currentNode.getLeft(), value));
            }
        } else if (currentNode.getKey().compareTo(value) == -1) {
            if (currentNode.getRight() == null) {
                return null;
            } else {
                return (FindValue(currentNode.getRight(), value));
            }
        }
        return currentNode.getKey();
    }

    protected Node<T> findNode(Node<T> currentNode, T value) {
        Node<T> nodeAux = new Node<>();

        if (currentNode.getKey().equals(value)) {
            return currentNode;
        }

        if (currentNode.getKey().compareTo(value) == 1) {
            if (currentNode.getLeft() == null) {
                return null;
            } else {
                nodeAux = findNode(currentNode.getLeft(), value);
            }
        } else if (currentNode.getKey().compareTo(value) == -1) {
            if (currentNode.getRight() == null) {
                return null;
            } else {
                nodeAux = findNode(currentNode.getRight(), value);
            }
        }
        return null;
    }

    public boolean contains(Node<T> currentNode, T value){
        return !(findNode(currentNode, value) == null);
    }

    private boolean hasTwoChild(Node<T> currentNode){
        return (currentNode.getLeft() != null && currentNode.getRight() != null);
    }

    private boolean hasOneChild(Node<T> currentNode){
        return (currentNode.getLeft() != null || currentNode.getRight() != null);
    }

    private boolean isLeaf(Node<T> currentNode){
        return (currentNode.getLeft() == null && currentNode.getRight() == null);
    }

    public int size(Node<T> currentNode) {
        if (currentNode == null){
            return 0;
        }else{
            return 1 + size(currentNode.getLeft()) + size(currentNode.getRight());
        }
    }

    private T valueSubstitute(Node<T> currentNode){
        if (currentNode.getRight() != null) {
            return (valueSubstitute(currentNode.getRight()));
        }
        return currentNode.getKey();
    }

    public void removeBT(T value) {
        removeNode(this.root, value);
    }

    private Node<T> removeNode(Node<T> currentNode, T value) {
        if (contains(currentNode, value)){
            if(currentNode.getKey().compareTo(value) == 1) {
                currentNode.setLeft(removeNode(currentNode.getLeft(), value));
            }else if(currentNode.getKey().compareTo(value) == -1) {
                currentNode.setRight(removeNode(currentNode.getRight(), value));
            }else{
                if(isLeaf(currentNode)){
                    currentNode = null;
                    return currentNode;
                } else if (hasTwoChild(currentNode)) {
                    T substituteValue = valueSubstitute(currentNode.getLeft());
                    currentNode.setKey(substituteValue);
                    currentNode.setLeft(removeNode(currentNode.getLeft(), substituteValue));
                } else if (hasOneChild(currentNode)) {
                    if (currentNode.getLeft() == null) {
                        return currentNode.getRight();
                    } else if (currentNode.getRight() == null) {
                        return currentNode.getLeft();
                    }
                }
            }
            return currentNode;
        }

        return null;
    }
}