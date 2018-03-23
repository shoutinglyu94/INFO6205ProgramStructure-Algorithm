/*
 * Copyright (c) 2017. Phasmid Software
 */
package algo.chap3.search;
import java.util.Map;

public class STMap <Key, Value> implements ST<Key, Value>{

    public Value get(Object key) {
        return map.get(key);
    }

    public void put(Key key, Value value) {
        map.put(key, value);
    }

    public STMap(Map<Key,Value> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return map.toString();
    }

    private final Map<Key, Value> map;
}
