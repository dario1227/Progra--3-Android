package datos1.tec.org.packettec.dataStructures;

public class BinaryTreeNode<T extends Comparable<T>> {
    private T value;
    private BinaryTreeNode<T> right;
    private BinaryTreeNode<T> left;

    public BinaryTreeNode(T Value, BinaryTreeNode<T> Right, BinaryTreeNode<T> Left) {
        value = Value;
        right = Right;
        left = Left;
    }

    public BinaryTreeNode(T Value) {
        this(Value, null, null);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> Right) {
        right = Right;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> Left) {
        left = Left;
    }


    public boolean hasChildren() {
        return (right != null || left != null);
    }
}
