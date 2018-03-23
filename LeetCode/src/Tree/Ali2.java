/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author lvsho
 */
public class Ali2 {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args){
    A a  =new A();
        try {
            atomicInteger.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch(IllegalMonitorStateException ex){
            ex.printStackTrace();
        }
        a.start();
    }

    static class A extends Thread {
        @Override
        public void run() {
            atomicInteger.notify();
            atomicInteger.lazySet(1);
            System.out.println(atomicInteger.get());
        }
        
    }
}
