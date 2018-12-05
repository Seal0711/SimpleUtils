package MyHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.carrotsearch.sizeof.RamUsageEstimator;


public class Test {
	public static void main(String[] args) {
		String a="agesss";
		System.out.println(hashCode(a));
		System.out.println(hashCode(a)&15);
	}
	public static int hashCode(Object key){
		int h;
		return (key==null)?0:(h=key.hashCode())^(h>>>16);
	}
}