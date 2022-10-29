
/**
 * Implements the node of a doubly linked list of integers.
 *
 * @author (Rodney Graham Panther ID 6196375)
 * Used code from LinkedList lecture for Nodes
 */
public class Node
{

    private int info;
    private Node next;
    private Node prev;

    public Node()
    {
        //TO IMPLEMENT
        info = 0;
        next = null;
        prev = null;
    }

    public int getInfo()
    {
        return info;  //LinkedList lecture
    }

    public Node getNext()
    {
        return next;  //LinkedList lecture
    }

    public Node getPrev()
    {
        return prev;  //LinkedList lecture
    }

    public void setInfo(int i)
    {
        info = i; //LinkedList lecture
    }

    public void setNext(Node n)
    {
        next = n; //LinkedList lecture
    }

    public void setPrev(Node p)
    {
        prev = p; //LinkedList lecture
    }

}
