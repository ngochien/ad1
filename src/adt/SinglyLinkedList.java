/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;


/**
 * @author Le
 */
public class SinglyLinkedList<E> implements List<E> {

	private int size = 0;

	private Node<E> head;

	public SinglyLinkedList() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see adt.List#size()
	 */
	@Override
	public int size() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see adt.List#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see adt.List#insert(int, java.lang.Object) // linkBefore(), add(int)
	 */
	@Override
	public void insert(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index + "Size: " + size);
		}

		System.out.print("INSERT an element at position " + index + " - ");

		Node<E> newNode = new Node<E>(element);
		if (isEmpty()) {
			head = newNode;
		} else if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node<E> node = node(index - 1);
			newNode.next = node.next;
			node.next = newNode;
		}
		size++;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see adt.List#delete(int)
	 */
	@Override
	public void delete(int index) {
		checkElementIndex(index);

		System.out.print("DELETE element at position " + index + " - ");

		if (index == 0) {
			head = head.next;
		} else {
			Node<E> node = node(index - 1);
			node.next = node.next.next;
		}
		size--;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see adt.List#find(java.lang.Object) // indexOf()
	 */
	@Override
	public int find(E element) {
		if (element == null) {
			throw new NullPointerException("element is null");
		}

		System.out.print("FIND an element - ");

		int index = 0;

		for (Node<E> node = head; node != null; node = node.next) {
			if (node.element.equals(element)) {
				System.out.println("Number of list accesses: " + index);
				return index;
			}
			index++;
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see adt.List#retrieve(int) // get(int)
	 */
	@Override
	public E retrieve(int index) {
		checkElementIndex(index);

		System.out.print("RETRIEVE element at position " + index + " - ");

		return node(index).element;
	}

	private Node<E> node(int index) {
		// assert index >= 0 && index < size

		Node<E> node = head;
		int counter = 1;
		for (int i = 0; i < index; i++) {
			node = node.next;
			counter++;
		}
		System.out.println("Number of list accesses: " + counter);
		return node;
	}

	private void checkElementIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index + "Size: " + size);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see adt.List#concat(adt.List)
	 */
	@Override
	public List<E> concat(List<E> otherList) {
		if (otherList == null) {
			throw new NullPointerException("otherList is null");
		}

		if (!(otherList instanceof SinglyLinkedList<?>)) {
			throw new IllegalArgumentException();
		}

		System.out.print("CONCAT - ");

		return concat((SinglyLinkedList<E>) otherList);
	}

	private SinglyLinkedList<E> concat(SinglyLinkedList<E> otherList) {
		// assert otherList != null

		SinglyLinkedList<E> newList;

		int diff = this.size - otherList.size;
		if (diff < 0) {
			newList = this;
			this.node(size-1).next = otherList.head;
		} else {
			newList = otherList;
			otherList.node(otherList.size - 1).next = this.head;
		}
		// size modifications of all lists : this, otherList and newList
		return newList;
	}

	@Override
	public String toString() {
		return null;
	}

	private static class Node<E> {
		E element;
		Node<E> next;

		Node(E element) {
			this.element = element;
			this.next = null;
		}
	}
}
