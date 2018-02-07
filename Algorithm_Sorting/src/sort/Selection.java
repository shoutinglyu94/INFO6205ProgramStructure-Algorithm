package sort;

public class Selection {
	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int min =i;
			for (int j = i + 1; j < a.length; j++) {
				if (Util.less(a[j], a[min])) {
					min = j;
				}
			}
			Util.exchange(a, i, min);
		}
	}
}
