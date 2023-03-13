import java.util.NoSuchElementException;

public class LinkedStack<E> implements StackInt<E> {
    // Insert inner class Node<E> here. (See Listing 2.1)
    private static class Node<E>
    {
        //data fields
        private E data; // reference to the data
        private Node<E> next; // reference to the next node

        //Constructors

        /**
         * Create a new node with a null next field.
         * @param dataItem The data stored
         */
        private Node(E dataItem)
        {
            data = dataItem;
            next = null;
        }

        /**
         * Create a new node that references another node
         * @param dataItem The data stored
         * @param nodeRef The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef)
        {
            data = dataItem;
            next = nodeRef;
        }
    }


    /**
     * The reference to the first stack node.
     */

    private Node<E> topOfStackRef = null;

    @Override
    public E push(E obj) {
        topOfStackRef = new Node<>(obj, topOfStackRef);
        return obj;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E result = topOfStackRef.data;
            topOfStackRef = topOfStackRef.next;
            return result;
        }

    }

    @Override public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException ();
        }
        else {
            return topOfStackRef.data;
        }
    }

    @Override
    public boolean isEmpty() {
        return topOfStackRef == null;
    }
}