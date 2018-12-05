package MyArrayList;

import java.util.Map;

public class SimpleHashMap<K,V> {
	
	/**
	 * 初始容量16
	 */
	private final int INIT_CAPACITY=1<<4;
	/**
	 * 最大容量2^30
	 */
	private final int MAX_CAPACITY=1<<30;
	/**
	 * 默认扩容因子0.75
	 */
	private final static float DEFAULT_LOAD_FACTORY=0.75f;
	/**
	 * 当链表长度超过8时，转化成树状结构
	 */
	private final int TRANSFORM_SIZE=8;
	/**
	 * 转化成树状结构时的最小容量
	 */
	private final int MIN_TREEIFY_CAPACITY = 64;
	/**
	 * 树结构化临界值
	 */
	private final int UNTREEIFY_THRESHOLD = 6;
	/**
	 * map的大小
	 */
	private int size=0;
	/**
	 * 当前容量
	 */
	private int capacity;
	/**
	 * 实际加载因子
	 */
	private float loadFactory;
	
	
	public SimpleHashMap(){
		this.loadFactory=DEFAULT_LOAD_FACTORY;
	}
	public SimpleHashMap(int capacity){
		this(capacity,DEFAULT_LOAD_FACTORY);
	}
	public SimpleHashMap(int capacity,float loadFactory){
		this.capacity=capacity;
		this.loadFactory=loadFactory;
	}
	public SimpleHashMap(Map<? extends K,? extends V> m){
		this();
		
	}
	
	
	
	
	
	
	
	
	
	class Node<K,V>{
		int hash;
		K key;
		V value;
		Node<K,V> next;
		Node(int hash,K key,V value,Node<K,V> next){
			this.hash=hash;
			this.key=key;
			this.value=value;
			this.next=next;
		}
		public K getKey(){
			return key;
		}
		public V getValue(){
			return value;
		}
		public Node<K,V> getNext(){
			return next;
		}
		@SuppressWarnings("unchecked")
		public V setValue(Object o){
			V oldValue=value;
			value=(V) o;
			return oldValue;
		}
		public Node<K,V> setNext(Node<K,V> n){
			Node<K,V> oldNode=next;
			next=n;
			return oldNode;
		}
		
	}
	class TreeNode<K,V>{
		
	}
}
