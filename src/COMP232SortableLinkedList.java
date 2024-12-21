/**
 * A sortable DoublyLinkedList.  The fields and the DLLNode class in the
 * COMP232DoublyLinkedList class are protected fields and can be accessed
 * directly in this class.
 * 
 * @author William Goble
 * @author Dickinson College
 * 
 */
public class COMP232SortableLinkedList<E extends Comparable<E>> extends COMP232DoublyLinkedList<E> {
	public void insertionSortList() {
		DLLNode<E> current = this.head.next.next;
	
		while (current != this.tail) {
			DLLNode<E> prevNode = current.prev;
			while (prevNode != this.head && prevNode.element.compareTo(current.element) > 0) {
				prevNode = prevNode.prev;
			}
			if (prevNode != current.prev) {
				current.prev.next = current.next;
				current.next.prev = current.prev;
				current.prev = prevNode;
				current.next = prevNode.next;
				prevNode.next.prev = current;
				prevNode.next = current;
			}
			current = current.next;
		}
	}
}
