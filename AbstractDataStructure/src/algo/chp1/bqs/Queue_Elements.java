package algo.chp1.bqs;

public class Queue_Elements<Item> implements Queue<Item> {

    public Queue_Elements() {
        oldest = null;
        newest = null;
    }

    /**
     * Enqueue the given item into the linked list referenced by oldest
     *
     * @param item the item to add
     */
    public void enqueue(Item item) {
        // TODO
        Element old = newest;
        newest = new Element<>(item, null);
        if (isEmpty()) {
            oldest = newest;
        } else {
            old.next = newest;
        }
    }

    public Item dequeue() {
        Item result;
        if(isEmpty()){
            result = null;
            newest = null;
        }else{
            result = oldest.item;
            oldest = oldest.next;
        }
        return result;
    }

    public boolean isEmpty() {
        return oldest == null;
    }

    // This Element essentially begins a LinkedList of Elements which correspond
    // to the elements that can be taken from the queue (head points to the oldest element).
    // However, it is built in manner that requires a pointer to the newest element.
    private Element<Item> oldest;

    // This element always points to the newest (tail-most) element in the LinkedList referenced by oldest.
    private Element<Item> newest;
}
