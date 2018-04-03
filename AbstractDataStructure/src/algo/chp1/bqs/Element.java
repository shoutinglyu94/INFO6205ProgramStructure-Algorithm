package algo.chp1.bqs;

/*
 * Copyright (c) 2017. Phasmid Software
 */


public class Element<Item> {
    Element(Item x, Element<Item> n) {
        item = x;
        next = n;
    }

    Element(Item x) {
        this(x, null);
    }

    final Item item;
    Element<Item> next;
}
