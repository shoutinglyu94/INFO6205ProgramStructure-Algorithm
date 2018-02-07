package sort;

public class Merge {
	public void merge(Comparable[] a,Comparable[] aux,int lo,int mid,int hi) {
		for(int k=0; k<a.length;k++) {
			aux[k] = a[k]; 
		}
		
		int i=lo;
		int j=mid+1;
		for(int k=0;k<a.length;k++) {
			if(i>mid) {
				aux[k] = a[j++];
			}else if(j>hi) {
				aux[k] = a[i++];
			}else if(Util.less(a[i], a[j])) {
				aux[k] = a[i++];
			}else {
				aux[k]  = a[j++];
			}
		}
	}
}
