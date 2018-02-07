package sort;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable<Double>[] test = Util.generateExample(10);
//		Selection.sort(test);
//		Insertion.sort(test);
//		Shell.sort(test);
//		Util.printResult(test);
		String str1 = "ab";
		String str2 = "ba";
		System.out.print(str1.compareTo(str2));
	}

}
