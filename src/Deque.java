import javax.naming.SizeLimitExceededException;
import java.util.Queue;

/**
 * The class Deque implements a double-ended queue with a doubly linked list.
 * The list uses a header and a trailer (dummy) nodes.
 *
 * @author (add here name and Panther ID)
 * Rodney Graham PID 6196375
 */
public class Deque
{

    /**
     * Default constructor. Sets this object as an empty deque.
     *
     */

    public Deque() // Deque constructor
    {

        front = new Node(); //empty Node for front
        back = new Node(); //empty Node for back
        front.setNext(back);
        back.setPrev(front);
        count = 0; //to be used for isEmpty method

    }


    /**
     * Adds new element to the back end of the deque. The method takes O(1)
     * time.
     *
     * @param x new element to be added to the deque.
     */
    public void addToBack(int x)
    {
        //TO IMPLEMENT

        Node current = new Node(); // create new empty Node to insert to back
        current.setInfo(x);// set the information for current

        current.setNext(back); //set next of current to back
        back.getPrev().setNext(current); //set previous of last node next to current
        current.setPrev(back.getPrev()); // set previous of current to previous last node
        back.setPrev(current); // set previous of back to current
        count++; //increment count
    }

    /**
     * Adds new element to the front end of the deque. The method takes O(1)
     * time.
     *
     * @param x new element to be added to the deque.
     */
    public void addToFront(int x)
    {
        //TO IMPLEMENT
        Node current = new Node(); //new Node to be created
        current.setInfo(x); // set info
        current.setPrev(front); // set previous node to front
        current.setNext(front.getNext()); //set next node to previous front node
        current.getNext().setPrev(current); //set previous of previous front node to current
        front.setNext(current); //set next of front to current
        count++; //increase counter
    }

    /**
     * Retrieves element on the back end of the deque. The method takes O(1)
     * time.
     *
     * @return operation is successful: valid = true and item = element on the
     * back end; operation is unsuccessful (i.e. empty deque): valid = false and
     * item = dummy value
     */
    public DequeItem getBack()
    {
        DequeItem item;
        if(!isEmpty()) // if not empty
            item = new DequeItem(true, back.getPrev().getInfo()); //returns the element found at the back of deque
        else // else empty
            item = new DequeItem();
        return item;
    }

    /**
     * Retrieves element on the front end of the deque. The method takes O(1)
     * time.
     *
     * @return operation is successful: valid = true and item = element on the
     * front end; operation is unsuccessful (i.e. empty deque): valid = false and
     * item = dummy value
     */
    public DequeItem getFront()
    {
        DequeItem item;
        if(!isEmpty()) //not empty
            item = new DequeItem(true, front.getNext().getInfo()); //returns the front element as long as the deque is not empty
        else //is empty
            item = new DequeItem();
        return item;
    }

    /**
     * Determines if deque is empty. The method takes O(1) time.
     *
     * @return true if deque contains no elements, false otherwise.
     */
    public boolean isEmpty()
    {
        return count == 0; //as long as the count is not 0, the deque is not empty
    }

    /**
     * Removes element on the back end of the deque. The method takes O(1) time.
     *
     * @return false if removal cannot be performed (i.e. the deque is empty),
     * true otherwise
     */
    public boolean removeBack()
    {
        if(!isEmpty()){ //can only remove items if elements exist in the deque
            back = back.getPrev(); //go back 2 values
            if(back != null) //
                back.setNext(null); // set 1 value forward to null
            count--; //update counter
            return true;
        }
        return false;
    }

    /**
     * Removes element on the front end of the deque. The method takes O(1)
     * time.
     *
     * @return false if removal cannot be performed (i.e. the deque is empty),
     * true otherwise
     */

    public boolean removeFront()
    {
        if(!isEmpty()){ //can only remove items if elements exist in the deque
            front = front.getNext(); //go forward 2 values
            if(front != null)
                front.setPrev(null); //remove previous value
            count--; //update counter
            return true;
        }
        return false;
    }

    /**
     * Constructs a String description of the deque.
     *
     * @return String containing the deque elements.
     */
    public String toString()
    {
        String str = "";

        Node current = front.getNext();
        for (int i = 0; i < count - 1; i++)
        {
            str += current.getInfo() + ", ";
            current = current.getNext();
        }

        if (count != 0)
            return "Deque: [" + str + back.getPrev().getInfo() + "]";
            //return "Deque: [" + str + "]";
        else
            return "Deque: []";
    }

    private int count;  //number of elements in the deque
    private Node back;  //points to the item in the back
    private Node front; //points to the item in the front

}
