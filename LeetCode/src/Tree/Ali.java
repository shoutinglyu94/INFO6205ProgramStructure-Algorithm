/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lvsho
 */
public class Ali {

    static class A {
    }

    static class B extends A {
    }

    public static void main(String[] args){
        ArrayList<A> list = new ArrayList<>();
        list.add(new B());
        method1(list);
    }

    private static void method1(List<? super A> list) { 
        for (int i = 0; i < list.size(); i++) {
            A a = (A) list.get(0);
        }
    }
}
