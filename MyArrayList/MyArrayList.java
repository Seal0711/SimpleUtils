package MyArrayList;

import java.io.Serializable;
import java.util.Arrays;
import java.util.RandomAccess;

public class MyArrayList<T> implements RandomAccess,Cloneable,Serializable {
	
	private static final long serialVersionUID = 1L;
	/*参数*/
	private final static int Init_Capacity=10;
	private int size=0;
	private Object[] main;
	//数组作为一个对象，需要一定的内存存储对象头信息，对象头信息最大占用内存不可超过8字节。
	//数组的对象头信息相较于其他Object，多了一个表示数组长度的信息。
	private final static int Max_Array_length=Integer.MAX_VALUE-8;
	
/******************************************************************/
	/*构造*/
	public MyArrayList(){
		this(Init_Capacity);
	}
	public MyArrayList(int size){
		if(size<0){
			throw new IllegalArgumentException("初始大小"+size);
		}else{
			main=new Object[size];
		}
	}
	
	
	/*主方法*/
	public void add(T t){
		isCapacityEnough(size+1);
		main[size++]=t;
	}
	public void add(int index,T t){
		checkRangeForAdd(index);
		isCapacityEnough(size+1);
		System.arraycopy(main, index, main, index+1, size-index);
		main[index]=t;
		size++;
	}
	
	
	public T remove(int index){
		T value=get(index);
		int removeSize=size-index-1;
		if(removeSize>0){
			System.arraycopy(main, index+1, main, index, removeSize);
		}
		main[--size]=null;
		return value;
	}
	
	
	public boolean remove(Object o){
		if(contain(o)){
			remove(indexOf(o));
			return true;
		}else{
			return false;
		}
	}
	
	public T get(int index){
		checkRange(index);
		return (T)main[index];
	}
	
	//一个元素是否在本集合内
	public boolean contain(Object o){
		return indexOf(o)>=0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
/******************************************************************/
	/*辅助方法*/
	private void isCapacityEnough(int size){
		if(size>Init_Capacity){
			explicitCapacity(size);
		}
		if(size<0){
			throw new OutOfMemoryError();
		}
	}
	
	//显性容量
	private void explicitCapacity(int capacity){
		//以2倍于默认数组长度定义新数组的长度
		int newLength=main.length*2;
		//扩容后数组长度还不足则直接将长度定义为capacity
		if(newLength-capacity<0){
			newLength=capacity;
		}
		//新数组超过最大数组长度，则将新数组长度定义为
		if(newLength>Max_Array_length){
			//新数组长度不得超过最大值
			newLength=capacity>Max_Array_length?Integer.MAX_VALUE:Max_Array_length;
		}
		//将原数组拷贝，并重新定义长度
		main=Arrays.copyOf(main, newLength);
	}
	
	//添加元素下标越界处理
	private void checkRangeForAdd(int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("下标越界");
		}
	}
	
	//取出元素时下标越界处理
	private void checkRange(int index){
		if(index<0||index>=size){
			throw new IndexOutOfBoundsException("下标越界");
		}
	}
	
	//判断元素是否在本集合内，如果存在则返回下标，否则返回-1
	private int indexOf(Object o){
		if(o!=null){
			for(int i=0;i<size;i++){
				if(o.equals(main[i])){
					return i;
				}
			}
		}else{
			for(int i=0;i<size;i++){
				if(main[i]==null){
					return i;
				}
			}
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
