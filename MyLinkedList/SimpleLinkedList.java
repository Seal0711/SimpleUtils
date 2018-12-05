package MyLinkedList;

import java.util.Collection;

/**
 * 
 * @ClassName:  SimpleLinkedList   
 * @Description:	the function is similar to LinkedList   
 * @author: Seal 
 * @date:   2018年07月24日 下午5:59:19   
 *   
 * @param <E> the type of elements to be determined 
 */
public class SimpleLinkedList<E> {
	/**
	 * the size of SimpleLinkedList
	 */
	private int size=0;
	
	/**
	 * always point to the first node while adding or removing elements
	 */
	private Node<E> first;
	
	/**
	 * always point to the last node while adding or removing elements
	 */
	private Node<E> last;
	
	
	
	/**
	 * 
	 * @Title: add   
	 * @Description: append an element to the end of the list
	 * @param: e the element to be appended
	 * @return: boolean if the method successfully executed
	 */
	public boolean add(E e){
		if(first==null){
			addFirst(e);
		}else{
			addLast(e);
		}
		return true;
	}
	
	/**
	 * 
	 * @Title: add   
	 * @Description: append an element to specified position
	 * @param index the specified position 
	 * @param e the element to be appended
	 * @return boolean if the method successfully executed
	 * @throws IndexOutOfBoundsException when the specified position is illegal to the list
	 */
	public boolean add(int index,E e){
		if(size==0){
			if(index==0){
				addFirst(e);
			}else{
				throw new IndexOutOfBoundsException(indexOutOfBounds(index));
			}
		}
		if(index==0){
			Node<E> f=first;
			Node<E> newNode=new Node<>(null, e, f);
			first=newNode;
			f.prev=newNode;
			size++;
		}else if(index==size){
			addLast(e);
		}else{
			Node<E> node=node(index);
			Node<E> prevNode=node.prev;
			Node<E> newNode=new Node<>(prevNode, e, node);
			node.prev=newNode;
			prevNode.next=newNode;
			size++;
		}
		return true;
	}
	
	/**
	 * the following four method are aimed at appending a list to the end of this list
	 * or specified position of this list
	 * @Title: addAll   
	 * @Description:   
	 * @param: c the list to be appended
	 * @param: index the specified position      
	 * @return: boolean if the method successfully executed
	 * @throws: NegativeArraySizeException when the list is empty
	 * @throws: IndexOutOfBoundsException when the index is wrong position
	 */
	public boolean addAll(Collection<? extends E> c){
		return addAll(size, c);
	}
	public boolean addAll(SimpleLinkedList<E> c){
		return addAll(size,c);
	}
	public boolean addAll(int index,Collection<? extends E> c){
		Object[] arr=c.toArray();
		return addCollect(index, arr);
	}
	public boolean addAll(int index,SimpleLinkedList<E> c){
		Object[] arr=c.toArray();
		return addCollect(index, arr);
	}
	
	/**
	 * 
	 * @Title: addCollect   
	 * @Description: Providing services for the above four methods
	 * @param index the specified position 
	 * @param arr the array to be appended
	 * @return boolean if the method successfully executed
	 * @throws: NegativeArraySizeException when the list is empty
	 * @throws: IndexOutOfBoundsException when the index is wrong position
	 */
	private boolean addCollect(int index,Object[] arr){
		int length=arr.length;
		Node<E> node,prevNode;
		if(length==0){
			return false;
		}
		if(index==size){
			node=null;
			prevNode=last;
		}else{
			node=node(index);
			prevNode=node.prev;
		}
		for(Object o:arr){
			@SuppressWarnings("unchecked")
			E e=(E) o;
			Node<E> newNode=new Node<>(prevNode, e, null);
			if(prevNode==null){
				first=newNode;
			}else{
				prevNode.next=newNode;
			}
			prevNode=newNode;
		}
		if(node==null){
			last=prevNode;
		}else{
			prevNode.next=node;
			node.prev=prevNode;
		}
		size+=length;
		return true;
	}
	
	/**
	 * 
	 * @Title: addFirst   
	 * @Description: add an element at the head of list
	 * @param e the element to be appended
	 */
	private void addFirst(E e){
		Node<E> f=first;
		Node<E> newNode=new Node<>(null, e, f);
		first=newNode;
		last=newNode;
		size++;
	}
	
	/**
	 * 
	 * @Title: addLast   
	 * @Description: add an element at the end of list
	 * @param e the element to be appended
	 */
	private void addLast(E e){
		Node<E> l=last;
		Node<E> newNode=new Node<>(l, e, null);
		last=newNode;
		l.next=newNode;
		size++;
	}
	
	/**
	 * 
	 * @Title: remove   
	 * @Description: remove an element that first appears
	 * @param e the element to be removed
	 * @return  boolean if the method successfully executed
	 */
	public boolean remove(E e){
		if(e==null){
			for(Node<E> i=first;i!=null;i=i.next){
				if(i.item==null){
					unlink(i);
					return true;
				}
			}
		}else{
			for(Node<E> i=first;i!=null;i=i.next){
				if(e.equals(i.item)){
					unlink(i);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @Title: remove   
	 * @Description: remove an element at the specified position
	 * @param index the specified position
	 * @return boolean if the method successfully executed
	 * @throws: NegativeArraySizeException when the list is empty
	 * @throws: IndexOutOfBoundsException when the index is wrong position
	 */
	public boolean remove(int index){
		return remove(node(index).item);
	}
	
	/**
	 * 
	 * @Title: unlink   
	 * @Description: Providing services for the method remove(E) and remove(int)
	 * @param n the node to be removed
	 * @return E the item of the deleted node
	 */
	private E unlink(Node<E> n){
		E element=n.item;
		Node<E> prev=n.prev;
		Node<E> next=n.next;
		if(prev==null){
			first=next;
		}else{
			prev.next=next;
			n.prev=null;
		}
		
		if(next == null){
            last=prev;
        }else{
            next.prev=prev;
            n.next=null;
        }
		n.item = null;
        size--;
        return element;
	}
	
	/**
	 * 
	 * @Title: set   
	 * @Description: replace the item of node in specified position with new element
	 * @param index the specified position
	 * @param e the element to be replaced
	 * @return E the old element
	 * @throws: NegativeArraySizeException when the list is empty
	 * @throws: IndexOutOfBoundsException when the index is wrong position
	 */
	public E set(int index,E e){
		Node<E> node=node(index);
		E item=node.item;
		node.item=e;
		return item;
	}
	
	/**
	 * 
	 * @Title: size   
	 * @Description: get the size of list
	 * @return int the size of list  
	 */
	public int size(){
		return size;
	}
	
	/**
	 * 
	 * @Title: get   
	 * @Description: get the element by the specified position 
	 * @param index the specified position 
	 * @return E the target element
	 * @throws: NegativeArraySizeException when the list is empty
	 * @throws: IndexOutOfBoundsException when the index is wrong position
	 */
	public E get(int index){
		return node(index).item;
	}
	
	/**
	 * 
	 * @Title: node   
	 * @Description: get the node by the specified position
	 * @param index the specified position 
	 * @return Node<E> the wanted node  
	 * @throws: NegativeArraySizeException when the list is empty
	 * @throws: IndexOutOfBoundsException when the index is wrong position
	 */
	private Node<E> node(int index) {
		checkIndexOfElement(index);
		if(index<(size>>1)){
			Node<E> x=first;
			for(int i=0;i<index;i++){
				x=x.next;
			}
			return x;
		}else{
			Node<E> x=last;
			for(int i=size-1;i>index;i--){
				x=x.prev;
			}
			return x;
		}
	}
	
	/**
	 * 
	 * @Title: getIndex   
	 * @Description: get the position of the specified element that first appears
	 * @param e the specified element
	 * @return int the position of element that first appears.if the element
	 * is not in this list,than return -1
	 * @throws: NegativeArraySizeException when the list is empty
	 * @throws: IndexOutOfBoundsException when the index is wrong position
	 */
	public int getIndex(E e){
		for(int i=0;i<size;i++){
			if(node(i).item==e){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @Title: getLastIndex   
	 * @Description: get the position of the specified element that last appears
	 * @param e the specified element
	 * @return int the position of element that last appears.if the element
	 * is not in this list,than return -1
	 * @throws: NegativeArraySizeException when the list is empty
	 * @throws: IndexOutOfBoundsException when the index is wrong position
	 */
	public int getLastIndex(E e){
		for(int i=size-1;i>=0;i--){
			if(node(i).item==e){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @Title: clear   
	 * @Description: delete all the nodes in this list
	 * @throws
	 */
	public void clear(){
		for(Node<E> node=first;node.next!=null;){
			Node<E> cache=node.next;
			node.item=null;
			node.prev=null;
			node.next=null;
			node=cache;
		}
		first=last=null;
		size=0;
	}
	
	/**
	 * 
	 * @Title: contains   
	 * @Description: if the specified element will appear in this list
	 * @param e the specified element
	 * @return boolean if the specified element will appear in this list
	 * @throws: NegativeArraySizeException when the list is empty
	 * @throws: IndexOutOfBoundsException when the index is wrong position
	 */
	public boolean contains(E e){
		return getIndex(e)!=-1;
	}
	
	/**
	 * 
	 * @Title: toArray   
	 * @Description: transform the list to array
	 * @return Object[] the target array
	 */
	public Object[] toArray(){
		Object[] arr=new Object[size];
		int i=0;
		for(Node<E> node=first;node!=null;node=node.next){
			arr[i++]=node.item;
		}
		return arr;
	}
	
	/**
	 * 
	 * @Title: toStrings   
	 * @Description: View the contents of the current list
	 * @return StringBuilder the contents 
	 * @throws: NegativeArraySizeException when the list is empty
	 * @throws: IndexOutOfBoundsException when the index is wrong position
	 */
	public StringBuilder toStrings(){
		StringBuilder str=new StringBuilder();
		if(size>0){
			str.append("[");
			for(int i=0;i<size;i++){
				if(i==size-1){
					str.append(node(i).item);
				}else{
					str.append(node(i).item).append(",");
				}
			}
			str.append("]").toString();
		}else{
			return null;
		}
		return str;
	}
	
	/**
	 * 
	 * @Title: checkIndexOfElement   
	 * @Description: Check the validity of the current list
	 * @param index the param to be checked
	 * @return boolean if the list is reasonable
	 * @throws: NegativeArraySizeException when the list is empty
	 * @throws: IndexOutOfBoundsException when the index is wrong position
	 */
	private boolean checkIndexOfElement(int index){
		if(size<=0){
			throw new NegativeArraySizeException("The Collection is empty");
		}
		if(index<0 | index>size-1){
			throw new IndexOutOfBoundsException(indexOutOfBounds(index));
		}
		return true;
	}
	
	/**
	 * 
	 * @Title: indexOutOfBounds   
	 * @Description: message of exception
	 * @param index the param to be checked
	 * @return String error message
	 */
	private String indexOutOfBounds(int index){
		if(index<0){
			return "Index "+index+" is a negative number";
		}else{
			return "Index "+index+" is larger than Collection size";
		}
	}
	
	/**
	 * 
	 * @ClassName:  Node   
	 * @Description: Node class
	 * @author: Seal 
	 * @date:   2018年11月26日 下午12:31:00   
	 *   
	 * @param <E>
	 */
	private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}