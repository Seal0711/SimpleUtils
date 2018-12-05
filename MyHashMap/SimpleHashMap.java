package MyHashMap;

import java.util.Map;
import java.util.Objects;

public class SimpleHashMap<K,V> {
	
	//一个桶的树化阈值
	//当桶中元素个数超过这个值时，需要使用红黑树节点替换链表节点
	//这个值必须为 8，要不然频繁转换效率也不高
	static final int TREEIFY_THRESHOLD = 8;
	//一个树的链表还原阈值
	//当扩容时，桶中元素个数小于这个值，就会把树形的桶元素 还原（切分）为链表结构
	//这个值应该比上面那个小，至少为 6，避免频繁转换
	static final int UNTREEIFY_THRESHOLD = 6;
	//哈希表的最小树形化容量
	//当哈希表中的容量大于这个值时，表中的桶才能进行树形化
	//否则桶内元素太多时会扩容，而不是树形化
	//为了避免进行扩容、树形化选择的冲突，这个值不能小于 4 * TREEIFY_THRESHOLD
	static final int MIN_TREEIFY_CAPACITY = 64;
	
	
	
	
	private static final int INIT_CAPACITY=16;
	private int capacity;
	private static final float INIT_EXTEND_FACTORY=0.75f;
	private float extendFactory;
	private int size=0;
	private TreeNode<K,V>[] arr;
	
	
	public SimpleHashMap(){
		this(INIT_CAPACITY, INIT_EXTEND_FACTORY);
	}
	public SimpleHashMap(int capacity){
		this(capacity,INIT_EXTEND_FACTORY);
	}
	public SimpleHashMap(int capacity,float extendFactory){
		this.capacity=checkCapacity(capacity);
		this.extendFactory=checkFactory(extendFactory);
	}
	public SimpleHashMap(Map<? extends K,? extends V> m){
		
	}
	
	
	
	
	private int checkCapacity(int capacity){
		if(capacity<0){
			throw new IllegalArgumentException("Negative capacity:"+capacity);
		}else if(capacity<=1<<4){
			capacity=1<<4;
		}else{
			capacity=caculateCapacity(capacity);
		}
		return capacity;
	}
	private int caculateCapacity(int capacity){
		int base=1<<4;
		do {
			base<<=1;
		} while (base<capacity);
		return base;
	}
	private float checkFactory(float extendFactory){
		if(extendFactory<=0 || Float.isNaN(extendFactory) || extendFactory>=1){
			throw new IllegalArgumentException("Unreasonable factors: "+extendFactory);
		}
		return extendFactory;
	}
	//hash()
	private int hashCode(K key){
		int h;
		return (key==0)?0:(h=key.hashCode())^h>>>16;
	}
	//put()
	public void put(K key,V value){
		int hash;
		if(key==null){
			hash=0;
		}
		hash=hashCode(key);
		if(arr[hash]==null){
			//一个直接添加的方法，链表
		}else{
			//获取对应桶下元素的数量，
			
		}
		
		
		
	}
	//resize()
	private void resize(int hash){
		if(arr[hash]==null){
			return;
		}
		double threshold=capacity*extendFactory;
		if(size>=threshold){
			capacity*=2;
		}
	}
	//遍历树
	private void traverseTree(TreeNode<K,V> first){
		for(TreeNode<K, V> n=first;n.left!=null || n.right!=null;){
			hashCode(n.key);
		}
	}
	//遍历链表
	private void traverseLink(TreeNode<K,V> first){
		
	}
	//putVal()
	//putAll()
	//get()
	//getNode()
	//setKey
	//setValue
	//remove()
	//removeNode()
	//replace()
	
	//isEmpty()
	//containKey()
	//containValue()
	//size()
	//clear()
	//toString()
	
	class TreeNode<K,V>{
		int hash;
		K key;
		V value;
		TreeNode<K,V> left;
		TreeNode<K,V> right;
		public TreeNode(K key,V value,TreeNode<K,V> left,TreeNode<K,V> right) {
			this.hash=hashCode();
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}
		public int hashCode(){
			return Objects.hashCode(key) ^ Objects.hashCode(capacity);
		}
		@Override
		public String toString() {
			return "hash="+hash+",key="+key+",value"+value;
		}
	}
}
