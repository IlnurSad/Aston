package homework1.task1;

public class MyHashSet<E> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<E>[] table = new Node[DEFAULT_CAPACITY];
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    public boolean add(E element) {
        int index = Math.abs(element.hashCode()) % table.length;
        Node<E> current = table[index];

        while (current != null) {
            if (current.data.equals(element)) return false;
            current = current.next;
        }

        Node<E> newNode = new Node<>(element);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
        return true;
    }

    public boolean remove(E element) {
        int index = Math.abs(element.hashCode()) % table.length;
        Node<E> current = table[index];
        Node<E> prev = null;

        while (current != null) {
            if (current.data.equals(element)) {
                if (prev == null) table[index] = current.next;
                else prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;

        for (Node<E> node : table) {
            Node<E> current = node;
            while (current != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(current.data);
                first = false;
                current = current.next;
            }
        }

        sb.append("]");
        return sb.toString();
    }
}