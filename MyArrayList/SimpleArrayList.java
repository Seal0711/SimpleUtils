package MyArrayList;

import java.util.Arrays;
import java.util.Collection;

/**
 * 
 * @ClassName:  SimpleArrayList   
 * @Description: the function is similar to Arraylist
 * @author: Seal 
 * @date:   2018年07月26日 上午12:36:51   
 *   
 * @param <E>
 */
public class SimpleArrayList<E> {
	/**
	 * default capacity of list
	 */
	private final static int init_Capacity=10;
	
	/**
	 * current capacity of list after adding operations
	 */
	private int currentCapacity=0;
	
	/**
	 * current size of list
	 */
	private int size=0;
	
	/**
	 * major array
	 */
	private Object[] arr;
	
	
	
	/**
	 * 
	 * @Title:  SimpleArrayList   
	 * @Description:  Constructs an empty list with an initial capacity of ten. 
	 * @throws	IllegalArgumentException with the wrong index such as negative number
	 */
	public SimpleArrayList(){
		this(init_Capacity);
	}
	
	/**
	 * 
	 * @Title:  SimpleArrayList   
	 * @Description:	Constructs an empty list with the specified initial capacity.
	 * @param:  size the specified initial capacity 
	 * @throws	IllegalArgumentException with the wrong index such as negative number
	 */
	public SimpleArrayList(int size){
		if(size<0){
			throw new IllegalArgumentException("wrong size of array"+size);
		}else{
			arr=new Object[size];
			currentCapacity=size;
		}
	}
	
	/**
	 * 
	 * @Title: add   
	 * @Description: appends the specified element to the end of this list
	 * @param e the specified element
	 * @return boolean whether the specified element is appended to the end of this list
	 */
	public boolean add(E e){
		isCapacityEnough(size+1);
		arr[size++]=e;
		return true;
	}
	
	/**
	 * 
	 * @Title: add   
	 * @Description: appends the specified element to the specified position of this list
	 * @param index the specified position
	 * @param e the specified element
	 * @return boolean whether the specified element is appended to the specified position
	 * of this list
	 * @throws IndexOutOfBoundsException when the specified position is illegal to the list
	 */
	public boolean add(int index,E e){
		checkIndexOfArray(index);
		isCapacityEnough(size+1);
		System.arraycopy(arr, index, arr, index+1, size-index);
		arr[index]=e;
		size++;
		return true;
	}
	
	/**
	 * 
	 * @Title: addAll   
	 * @Description: appends the list extends or implements Collection to the end of 
	 * this list
	 * @param c the list extends or implements Collection
	 * @return boolean whether the specified list is appended to the end of this list 
	 */
	public boolean addAll(Collection<? extends E> c){
		Object[] o=c.toArray();
		return addCollection(o);
	}
	
	/**
	 * 
	 * @Title: addAll   
	 * @Description: appends the list SimpleArrayList to the end of this list
	 * @param c the list SimpleArrayList
	 * @return boolean whether the specified SimpleArrayList is appended to the
	 * end of list
	 */
	public boolean addAll(SimpleArrayList<E> c){
		Object[] o=c.toArray();
		return addCollection(o);
	}
	
	/**
	 * this method serves the above two methods
	 * @Title: addCollection   
	 * @Description: appends the Object array to the end of this list
	 * @param o the Object array
	 * @return boolean whether the specified Object array is appended to the
	 * end of list
	 */
	private boolean addCollection(Object[] o){
		int length=o.length;
		int currentIndex=size;
		isCapacityEnough(size+length);
		for(int i=0;i<length;i++){
			arr[currentIndex+i]=o[i];
		}
		size+=length;
		return true;
	}
	
	/**
	 * 
	 * @Title: addAll   
	 * @Description: appends the list extends or implements Collection to the specified
	 * position of this list
	 * @param index the specified position
	 * @param c the list extends or implements Collection
	 * @return boolean whether the specified list is appended to the specified position
	 * of this list
	 * @throws IndexOutOfBoundsException when the specified position is illegal to the list
	 */
	public boolean addAll(int index,Collection<? extends E> c){
		checkIndexOfArray(index);
		Object[] o=c.toArray();
		return addCollection(index, o);
	}
	
	/**
	 * 
	 * @Title: addAll   
	 * @Description: appends the list SimpleArrayList to the specified position 
	 * of this list
	 * @param index the specified position
	 * @param c the list SimpleArrayList
	 * @return boolean whether the specified list is appended to the specified position
	 * of this list
	 * @throws IndexOutOfBoundsException when the specified position is illegal to the list
	 */
	public boolean addAll(int index,SimpleArrayList<E> c){
		Object[] o=c.toArray();
		return addCollection(index, o);
	}
	
	/**
	 * this method serves the above two methods
	 * @Title: addCollection   
	 * @Description: appends the Object array to the specified position of this list
	 * @param index the specified position
	 * @param o the Object array
	 * @return boolean whether the specified Object array is appended to the
	 * specified position of list
	 * @throws IndexOutOfBoundsException when the specified position is illegal to the list
	 */
	private boolean addCollection(int index,Object[] o){
		checkIndexOfArray(index);
		int length=o.length;
		isCapacityEnough(size+length);
		System.arraycopy(arr, index, arr, index+length, size-index);
		for(int i=0;i<length;i++){
			arr[index++]=o[i];
		}
		size+=length;
		return true;
	}
	
	/**
	 * 
	 * @Title: remove   
	 * @Description: removes the elements at the specified position in this list
	 * @param index the specified position
	 * @return E the replaced element
	 * @throws IndexOutOfBoundsException when the specified position is illegal to the list
	 */
	public E remove(int index){
		E e=get(index);
		deleteSingle(index);
		return e;
	}
	
	/**
	 * 
	 * @Title: get   
	 * @Description: get the element by the specified position
	 * @param index the specified position 
	 * @return E the target element
	 * @throws IndexOutOfBoundsException when the specified position is illegal to the list
	 */
	public E get(int index){
		checkIndexOfArray(index);
		@SuppressWarnings("unchecked")
		E e=(E) arr[index];
		return e;
	}
	
	/**
	 * this method serves the method remove(int index) and remove(Object o)
	 * @Title: deleteSingle   
	 * @Description: one step of method remove
	 * @param index the specified position
	 */
	private void deleteSingle(int index){
		if(index<=size-1){
			System.arraycopy(arr, index+1, arr, index, size-index-1);
		}
		arr[--size]=null;
	}
	
	/**
	 * 
	 * @Title: remove   
	 * @Description: removes the elements with the specified element in this list
	 * @param o the specified element
	 * @return int the first index of the removed element
	 */
	public int remove(Object o){
		if(o==null){
			for(int i=0;i<size;i++){
				if(arr[i]==null){
					deleteSingle(i);
					return i;
				}
			}
		}else{
			for(int i=0;i<size;i++){
				if(o.equals(arr[i])){
					deleteSingle(i);
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @Title: checkIndexOfArray   
	 * @Description: whether the specified position legal
	 * @param index the specified position
	 * @throws IndexOutOfBoundsException when the specified position is illegal to the list
	 */
	private void checkIndexOfArray(int index){
		if(index<0 || index>size){
			throw new IndexOutOfBoundsException("Wrong param index: "+index);
		}
	}
	
	/**
	 * 
	 * @Title: isCapacityEnough   
	 * @Description: if the size of list is larger than currentCapacity after adding
	 * extends this list
	 * @param size the size of list after adding
	 */
	private void isCapacityEnough(int size){
		if(size>currentCapacity){
			extendList(size);
		}
	}
	
	/**
	 * 
	 * @Title: extendList   
	 * @Description: extends currentCapacity of this list
	 * @param size the target size of this list
	 */
	private void extendList(int size){
		currentCapacity*=2;
		if(currentCapacity<size){
			currentCapacity=size;
		}
		arr=Arrays.copyOf(arr, currentCapacity);
	}
	
	/**
	 * 
	 * @Title: contains   
	 * @Description: if the specified element will appear in this list
	 * @param o the specified element
	 * @return boolean if the specified element will appear in this list
	 */
	public boolean contains(Object o){
		return indexOf(o)!=-1;
	}
	
	/**
	 * 
	 * @Title: indexOf   
	 * @Description: return the index of specified element when first appear in this list,
	 * return -1 if there is no such element
	 * @param o the specified element
	 * @return int the index of specified element when first appear in this list
	 * return -1 if there is no such element
	 */
	public int indexOf(Object o){
		if(o==null){
			for(int i=0;i<size;i++){
				if(arr[i]==null){
					return i;
				}
			}
		}else{
			for(int i=0;i<size;i++){
				if(o.equals(arr[i])){
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @Title: lastIndexOf   
	 * @Description: return the last index of specified element when last appear in this list,
	 * return -1 if there is no such element
	 * @param o the specified element
	 * @return int the last index of specified element when last appear in this list
	 * return -1 if there is no such element
	 */
	public int lastIndexOf(Object o){
		if(o==null){
			for(int i=size-1;i>=0;i--){
				if(arr[i]==null){
					return i;
				}
			}
		}else{
			for(int i=size-1;i>=0;i--){
				if(o.equals(arr[i])){
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @Title: set   
	 * @Description: replaced the old element in specified position with new element
	 * @param index the specified position
	 * @param e the new element
	 * @return E the old element
	 * @throws IndexOutOfBoundsException when the specified position is illegal to the list
	 */
	public E set(int index,E e){
		E replaced=get(index);
		arr[index]=e;
		return replaced;
	}
	
	/**
	 * 
	 * @Title: clear   
	 * @Description: delete all the elements in this list
	 */
	public void clear(){
		for(int i=0;i<size;i++){
			arr[i]=null;
		}
		size=0;
	}
	
	/**
	 * 
	 * @Title: isEmpty   
	 * @Description: whether the list is empty
	 * @return boolean whether the list is empty
	 */
	public boolean isEmpty(){
		return size==0;
	}
	
	/**
	 * 
	 * @Title: toArray   
	 * @Description: transform this list to array
	 * @return Object[] target Object array
	 */
	public Object[] toArray(){
		if(size==0){
			return null;
		}
		Object[] o=new Object[size];
		for(int i=0;i<size;i++){
			o[i]=arr[i];
		}
		return o;
	}
	
	/**
	 * 
	 * @Title: size   
	 * @Description: get the size of this list
	 * @return int the size of this list
	 */
	public int size(){
		return size;
	}
	
	/**
	 * 
	 * @Title: toStrings   
	 * @Description: View the contents of the current list
	 * @return StringBuilder the contents
	 * @throws
	 */
	public StringBuilder toStrings() {
		if(size==0){
			return null;
		}
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null){
				if(i==size-1){
					sb.append(arr[i]);
				}else{
					sb.append(arr[i]).append(",");
				}
			}
		}
		sb.append("]");
		return sb;
	}
}