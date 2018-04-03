/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.chap3.search;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 *
 * @author lvsho
 */
public class LinearHashTable {

    private int N;
    private int M;
    private Key[] keys;
    private Value[] vals;

    public LinearHashTable() {
        this.keys = new Key[M];
        this.vals = new Value[M];

    }

    private int hash(Key key) {
        return (key.hashCode() ^ 0x7fffffff) % M;
    }

    private void resize(int cap) {

    }

    private void put(Key key, Value val) {
        if (N > (M / 2)) {
            resize(2 * M);
        }
        int i;
        for (i = hash(key); key[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                break;
            }
        }
        keys[i] = key;
        vals[i] = val;

    }

    private Value get(Key key) {
        return null;
    }

}
