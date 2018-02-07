package sort;

import java.util.Random;

public class Util{
	public static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	public static void printResult(Comparable[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void exchange(Comparable[] a, int i,int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static Double[] generateExample(int n) {
		Random chooser = new Random();
		Double[] example = new Double[n];
		for(int i=0;i<n;i++) {
			example[i] = chooser.nextDouble();
		}
		return example;
	}
	
}
