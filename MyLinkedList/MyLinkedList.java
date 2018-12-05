package MyLinkedList;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList<E> implements Deque<E>,Cloneable, java.io.Serializable{
	private static final long serialVersionUID = 1L;
	int size=0;
	Node<E> firstNode;
	Node<E> last;
	public MyLinkedList() {
	}
	public MyLinkedList(Collection<? extends E> c){
		
	}
	/**
	 * @param	Object
	 * @return	boolean
	 */
	public boolean add(Object o){
		
		return false;
	}
	/**
	 * @param	int,String
	 * @return	boolean
	 */
	public boolean add(int index,Object o){
		
		return false;
	}
	/**
	 * @param	Collection
	 * @return	boolean
	 */
	public boolean addAll(Collection<? extends E> c){
		
		return false;
	}
	/**
	 * @param	int,Collection
	 * @return	boolean
	 */
	public boolean addAll(int index,Collection<? extends E> c){
		
		return false;
	}
	/**
	 * @param	int
	 * @return	Object
	 */
	public boolean get(int index){
		
		return false;
	}
	/**
	 * @param	int,E
	 * @return	E
	 */
	public E set(int index,E e){
		
		return null;
	}
	/**
	 * @param	
	 * @return	int
	 */
	public int size(){
		
		return 0;
	}
	/**
	 * @param	
	 * @return	Iterator<E>
	 */
	public Iterator<E> iterator(){
		
		return null;
	}
	/**
	 * @param	Object
	 * @return	boolean
	 */
	public boolean contains(Object o){
		
		return false;
	}
	/**
	 * @param	Collection
	 * @return	boolean
	 */
	public boolean containsAll(Collection<?> c){
		
		return false;
	}
	/**
	 * @param	String
	 * @return	boolean
	 */
	public boolean isEmpty(){
		
		return false;
	}
	/**
	 * @param	Object
	 * @return	boolean
	 */
	public boolean remove(Object o){
		
		return false;
	}
	/**
	 * @param	int
	 * @return	E
	 */
	public E remove(int index){
		
		return null;
	}
	/**
	 * @param	
	 * @return	
	 */
	public void clear(){
		
	}
	/**
	 * @param	Object
	 * @return	boolean
	 */
	public boolean equals(Object o){
		
		return false;
	}
	
	/**
	 * @param	Object
	 * @return	int
	 */
	public int indexOf(Object o){
		
		return 0;
	}
	/**
	 * @param	
	 * @return	ListIterator
	 */
	public ListIterator<E> listIterator(){
		
		return null;
	}
	/**
	 * @param	int
	 * @return	ListIterator
	 */
	public ListIterator<E> listIterator(int index){
		
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean offerFirst(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean offerLast(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E pollLast() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E peekFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E peekLast() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeFirstOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeLastOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
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
