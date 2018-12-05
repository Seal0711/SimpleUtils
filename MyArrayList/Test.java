package MyArrayList;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		SimpleArrayList<String> sl=new SimpleArrayList<String>();
		sl.add("a");
		sl.add("b");
		sl.add("c");
		System.out.println(sl.toStrings());
		int a=sl.remove("d");
		System.out.println(a);
		System.out.println(sl.toStrings());
	}
}
