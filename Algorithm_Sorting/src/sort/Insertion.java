package sort;

public class Insertion {
	public static void sort(Comparable[] a) {
		for(int i=0;i<a.length;i++) {
			for(int j=i;j>0;j--) {
				if(Util.less(a[j], a[j-1])) {
					Util.exchange(a, j, j-1);
				}
			}
		}
	}
}
