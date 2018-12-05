package MyLinkedList;

import java.util.Collection;

public class TlinkedList<E> {
	int size=0;
	Node<E> first;
	Node<E> last;
	public TlinkedList() {
	}
	//建立第一个节点
	void linkFirst(E e){
		Node<E> f=first;
		Node<E> newNode=new Node<>(null,e,f);
		first=newNode;
		if(f==null){
			last=newNode;
		}else{
			f.prev=newNode;
		}
		size++;
	}
	//建立最后一个节点
	void linkLast(E e){
		Node<E> l=last;
		Node<E> newNode=new Node<>(l, e, null);
		last=newNode;
		if(l==null){
			first=newNode;
		}else{
			l.next=newNode;
		}
		size++;
	}
	//建立下一个节点
	void linkNext(E e){
		
	}
	//取消第一个节点
	E unLinkFirst(Node<E> f){
		
		return null;
	}
	//取消最后一个节点
	E unLinkLast(Node<E> l){
		
		return null;
	}
	//取消节点
	E nuLink(Node<E> n){
		
		return null;
	}
	//获取第一个节点
	E getFirst(){
		
		return null;
	}
	//获取最后一个节点
	E getlast(){
		
		return null;
	}
	//移除第一个节点
	E removeFirst(){
		
		return null;
	}
	//移除最后一个节点
	E removeLast(){
		
		return null;
	}
	//增加第一个
	void addFirst(E e){
		
	}
	//增加最后一个
	void addLast(E e){
		
	}
	//增加一个元素
	void add(E e){
		
	}
	//增加一个集合
	boolean addAll(Collection<? extends E> c){
		
		return false;
	}
	//增加一个集合
	boolean addAll(int index,Collection<? extends E> c){
		
		return false;
	}
	//是否包含某个元素
	boolean contains(Object o){
		
		return false;
	}
	//获取大小
	int size(){
		return size;
	}
	//移除元素
	boolean remove(Object o){
		
		return false;
	}
	boolean remove(int index){
		
		return false;
	}
	//清空
	void clear(){
		
	}
	//获取
	E get(int index){
		
		return null;
	}
	//设置
	E set(int index){
		
		return null;
	}
	//返回指定元素第一次出现的位置
	int indexOf(Object o){
		
		return 0;
	}
	//返回指定元素最后一次出现的位置
	int lastIndexOf(Object o){
		
		return 0;
	}
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
