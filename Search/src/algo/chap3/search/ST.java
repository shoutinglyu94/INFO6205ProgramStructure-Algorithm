/*
 * Copyright (c) 2017. Phasmid Software
 */

package algo.chap3.search;

public interface ST<Key, Value>{

    void put(Key key, Value val);

    Value get(Key key);

}