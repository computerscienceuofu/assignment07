package assignment06;

import java.util.*;


/**
 * 
 * @author Christopher Murphy && Li Yu
 *
 * @param <E>
 */
public class DoublyLinkedList<E> implements List<E>, Iterable<E>{
    
	//Here are the head and tail nodes and total list size
    int size;
    Node<E> head;
    Node<E> tail;
    
	@Override
	public void addFirst(E element) {
		
		Node<E> temp = new Node<E>(element);
		if (size == 0)
		{
			head = temp;
			tail = temp;
			head.prev = null;
			tail.next = null;
			size++;
		}
		
		else
		{		
			head.prev = temp;
			temp.next = head;
			head = temp;
			head.prev = null;
			tail.next = null;
			size++;
		}
		
	}

	@Override
	public void addLast(E o) {
		
		Node<E> newTail = new Node<E>(o);
		if (size == 0)
		{
			head = newTail;
			tail = newTail;
			head.prev = null;
			tail.next = null;
			size++;
		}
		
		else
		{
		tail.next = newTail;
		newTail.prev = tail;
		tail = newTail;
		head.prev = null;
		tail.next = null;
		size++;
		}
		
	}
	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException  {
		Node<E> temp = new Node<E>(element);
		Node<E> runner = head;
		
		if(size == 0 && index == 0)
		{
			head = temp;
			tail = temp;
			size++;
		}
		
		else if (index == 0 && size != 0) {
			runner.prev = temp;
			temp.next = runner;
			head = temp;
			size++;
		} 
		
		else if(index == size)
		{
			int x = 1;
			while (x < index)
			{
				runner = runner.next;
				x++;
			}
			
			runner.next = temp;
			temp.prev = runner;
			tail = temp;
			
			head.prev = null;

			
			size++;

		}
		else 
		{
			int x = 1;
			while (x < index)
			{
				runner = runner.next;
				x++;
			}
			Node<E> midTemp = runner.next;
			runner.next = temp;
			temp.prev = runner;
			temp.next = midTemp;
			midTemp.prev = runner.next;
			
			head.prev = null;
			tail.next = null;
			
			size++;

		}
	}

	@Override
	public E getFirst() throws NoSuchElementException {
		
		if(head == null){
			throw new NoSuchElementException();
		}
		return head.data;
	}

	@Override
	public E getLast() throws NoSuchElementException {
		if(tail == null){
			throw new NoSuchElementException();
		}
		return tail.data;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (size == 0 || index > size - 1)
		{
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> temp = head;	
		for(int i = 0; i < index + 1; i++)
		{
			if (i == index)
			{
				return temp.data;
			}
			temp = temp.next;
		}
		return temp.data;
			
	}

	@Override
	public E removeFirst() throws NoSuchElementException {
		
		if (head == null)
		{
			throw new NoSuchElementException();
		}
		
		E value = head.data;	
		Node<E> next = head.next;
		next.prev = null;
		head = head.next;
		size--;		
		return value;
	}

	@Override
	public E removeLast() throws NoSuchElementException {
		
		if (tail == null)
		{
			throw new NoSuchElementException();
		}
		
		E value = tail.data;
		tail = tail.prev;
		size--;
		return value;
				
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		
		if ((index >= size) || (index < 0))
			throw new IndexOutOfBoundsException();
		
		Node<E> temp = head;
		int x = 0;
		while (x < index)
		{
			temp = temp.next;
			x++;
		}
		if(index == 0)
		{
			removeFirst();
		}
		else if(index == size - 1)
		{
			removeLast();
		}
		
		else if (index != 0 || index != size - 1)
		{
			Node<E> left = temp.prev;
			Node<E> right = temp.next;
			left.next = right;
			right.prev = left;
			size--;
		}
		return temp.data;
	}

	@Override
	public int indexOf(E element) {
		if (size == 0)
		{
			throw new NoSuchElementException();
		}
		Node<E> temp = head;	
		for(int i = 0; i < size; i++)
		{
			if (temp.data == element)
			{
				return i;
			}
			temp = temp.next;
		}
		return -1;
		
	}

	@Override
	public int lastIndexOf(E element) {
		if (size == 0)
		{
			throw new NoSuchElementException();
		}
		Node<E> temp = head;	
		int index = 0;
		for(int i = 0; i < size; i++)
		{
			if (temp.data == element)
			{
				index = i;
			}
			temp = temp.next;
		}
		if (index != 0)
		{
			return index;
		}
		else if(head.data == element)
		{
			return 0;
		}
		else
		{
		return -1;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
		
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		Node<E> temp = head;
		
		for(int i = 0; i < size; i++)
		{
			array[i] = temp.data;
			temp = temp.next;
		}
		return array;
		
	}

	
	/**
	 * The iterator method steps through each element in the linked list.  It can also check if it has a next element and 
	 * also remove the current index.  
	 */
	@Override
	public Iterator<E> iterator() {
		
		Iterator<E> iter = new Iterator<E>() {

		 private Node<E> currentIndex = head;
		 int x = 0;
		 int counter = 0;


         @Override
         public boolean hasNext() {
        	 if (currentIndex.next != null)
        	 {
             return true;
        	 }
        	 return false;
			
         }

		@Override
         public E next() {
			if (currentIndex.next == null)
			{
				throw new NoSuchElementException();
			}
			
			if(x == 0)
			{
				x = 1;
				return currentIndex.data;
			}
			if (currentIndex.next.data == null)
			{
				x = 0;
			}
			currentIndex = currentIndex.next;
			counter++;
			return currentIndex.data;
             
         }

         @Override
         public void remove() {
        	if(currentIndex == null)
        	{
        		throw new IllegalStateException();
        	}
        	
        	if (currentIndex != null)        	 
        	{
                		
                	DoublyLinkedList.this.remove(counter); 
          
                	counter = 0;
        	 }
         }
     };
     
     return iter;
 }

}

