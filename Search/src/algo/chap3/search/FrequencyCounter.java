/*
 * Copyright (c) 2017. Phasmid Software
 */

package algo.chap3.search;
import java.util.HashMap;

public class FrequencyCounter {

    private final ST<String,Integer> map;

    public FrequencyCounter(ST<String,Integer> map) {
        this.map = map;
    }

    public void increment(String s) {
        // TODO implement me
    }

    public String toString() {
        return map.toString();
    }

    public static void main(String[] args) {
        FrequencyCounter counter = new FrequencyCounter(new STMap<>(new HashMap<>()));

        for (String arg: args) counter.increment(arg);

        System.out.println(counter.toString());
    }
}
