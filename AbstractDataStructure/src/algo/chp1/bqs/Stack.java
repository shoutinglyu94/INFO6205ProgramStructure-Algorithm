package algo.chp1.bqs;

/*
 * Copyright (c) 2017. Phasmid Software
 */


public interface Stack<Item> {

    /**
     * Update this Stack by adding an item on the top.
     *
     * @param item the item to add
     */
    void push(Item item);

    /**
     * Update this Stack by taking the top item of this Stack.
     *
     * @return the item.
     * @throws BQSException if this Stack is empty.
     */
    Item pop() throws BQSException;

    /**
     * Take the peek at the item on top of this Stack.
     *
     * @return the item.
     */
    Item peek();

    /**
     * @return true if this stack is empty
     */
    boolean isEmpty();
}
