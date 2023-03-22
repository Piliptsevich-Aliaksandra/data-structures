public class DoublyLinkedList {
    private Node first;
    private Node last;
    private int size;

    class Node {
        private Object element;
        private Node next;
        private Node previous;

        public Node(Object element) {
            this.element = element;
        }

        public Object getElement() {
            return element;
        }

        public void setElement(Object element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    public DoublyLinkedList() {
        this.size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    public void addLast(final Object element) {
        if (size == 0) {
            Node el = new Node(element);
            first = el;
            last = el;
        } else {
            Node el = new Node(element);
            el.setPrevious(last);
            last.setNext(el);
            last = el;
        }
        size++;
    }

    public void addFirst(final Object element) {
        if (size == 0) {
            Node el = new Node(element);
            first = el;
            last = el;
        } else {
            Node el = new Node(element);
            el.setNext(first);
            first.setPrevious(el);
            first = el;
        }
        size++;
    }

    public void add(final int index, final Object element) {
        for (int i = 0; i < index - size + 1; i++) {
            addLast(null);
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node before = first;
            for (int i = 0; i < index - 1; i++) {
                before = before.getNext();
            }
            Node after = before.getNext();
            Node el = new Node(element);
            el.setPrevious(before);
            el.setNext(after);
            before.setNext(el);
            after.setPrevious(el);
            size++;
        }
    }

    public Object remove(int index) {
        assert (index >= 0 && index < size);
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            Node before = first;
            for (int i = 0; i < index - 1; i++) {
                before = before.getNext();
            }
            Node el = before.getNext();
            before.setNext(null);
            last = before;
            size--;
            return el.getElement();
        } else {
            Node before = first;
            for (int i = 0; i < index - 1; i++) {
                before = before.getNext();
            }
            Node el = before.getNext();
            Node after = el.getNext();
            before.setNext(el.getNext());
            after.setPrevious(before);
            size--;
            return el.getElement();
        }
    }

    public Object removeFirst() {
        if (size == 1) {
            Node el = first;
            first = null;
            last = null;
            size--;
            return el.getElement();
        } else if (size > 1) {
            Node el = first;
            first = first.getNext();
            first.previous = null;
            size--;
            return el.getElement();
        } else {
            return null;
        }
    }

    public Object peekFirst() {
        if (size > 0) {
            return first.getElement();
        } else {
            return null;
        }
    }

    public Object search(final int index) {
        assert (index >= 0 && index < size);
        Node el = first;
        for (int i = 0; i < index; i++) {
            el = el.getNext();
        }
        return el.getElement();
    }

    public Object peekLast() {
        if (size > 0) {
            return last.getElement();
        } else {
            return null;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        while (!empty()) {
            removeFirst();
        }
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node el = first;
        for (int i = 0; i < size; i++) {
            array[i] = el.getElement();
            el = el.getNext();
        }
        return array;
    }

}
