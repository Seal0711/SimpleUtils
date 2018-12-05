package MyLinkedList;

import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		SimpleLinkedList<String> l1=new SimpleLinkedList<String>();
		SimpleLinkedList<String> l2=new SimpleLinkedList<String>();
		l1.add("a");
		l1.add("b");
		l1.add("c");
		l2.add("1");
		l2.add("2");
		l2.add("3");
		System.out.println(l1.toStrings());
		System.out.println(l2.toStrings());
		l1.addAll(l2);
		System.out.println(l1.toStrings());
	}
}
