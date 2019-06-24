import java.util.NoSuchElementException;

public class DoubLinkedList<T> {
    protected Node<T> head = null;
    protected Node<T> tail = null;
    protected long size = 0L;

    public DoubLinkedList() {
    }

    public long size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0L;
    }

    public void clear() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public T getFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        } else {
            return this.head.getValue();
        }
    }

    public T getLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        } else {
            return this.tail.getValue();
        }
    }

    public void addFirst(T value) {
        Node<T> first = new Node();
        first.setValue(value);
        first.setNext(this.head);
        if (this.head == null) {
            this.tail = first;
        }
        this.head = first;
        ++this.size;
    }

    public void addLast(T value) {
        if (this.head == null) {
            this.addFirst(value);
        } else {
            Node<T> last = new Node();
            last.setValue(value);
            this.tail.setNext(last);
            last.setPrevious(tail);
            this.tail = last;
            ++this.size;
        }

    }

    public T removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        } else {
            T value = this.head.getValue();
            this.head = this.head.getNext();
            --this.size;
            return value;
        }
    }

    public T removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        } else {
            T value = this.tail.getValue();

            Node <T> temp = null;
            if (tail.getPrevious() != null){
                temp = tail.getPrevious();
            }
            //for(temp = this.head; temp.getNext() != null && temp.getNext() != this.tail; temp = temp.getNext()) {
            //}

            temp.setNext(null);
            this.tail.setPrevious(null);
            this.tail = temp;
            tail.setNext(null);
            --this.size;
            return value;
        }
    }

    public boolean contains(T value) {
        for(Node temp = this.head; temp != null; temp = temp.getNext()) {
            if (temp.getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    public Object[] toArray() {
        Object[] array = new Object[(int)this.size];
        Node<T> temp = this.head;

        for(int i = 0; (long)i < this.size; ++i) {
            array[i] = temp.getValue();
            temp = temp.getNext();
        }

        return array;
    }

    public T get(int index) {
        if ((long)index < this.size && index >= 0) {
            Node<T> temp = this.head;

            for(int i = 0; i < index; ++i) {
                temp = temp.getNext();
            }

            return temp.getValue();
        } else {
            throw new IndexOutOfBoundsException("index " + index);
        }
    }

    public T remove(int index) {
        if ((long)index < this.size && index >= 0) {
            Node<T> temp = this.head;
            Node<T> before = null;

            for(int i = 0; i < index; ++i) {
                before = temp;
                temp = temp.getNext();
            }

            if (before == null) {
                this.head = temp.getNext();
            } else {
                before.setNext(temp.getNext());
                if (temp == this.tail) {
                    this.tail = before;
                }
            }

            --this.size;
            return temp.getValue();
        } else {
            throw new IndexOutOfBoundsException("index " + index);
        }
    }

    public void add(int index, T value) {
        if ((long)index <= this.size && index >= 0) {
            Node<T> temp = this.head;
            Node<T> before = null;

            for(int i = 0; i < index; ++i) {
                before = temp;
                temp = temp.getNext();
            }

            Node<T> newNode = new Node();
            newNode.setValue(value);
            newNode.setNext(temp);
            newNode.setPrevious(before);
            if (before == null) {
                this.head = newNode;
            } else {
                before.setNext(newNode);
                if (temp == this.tail) {
                    this.tail = newNode;
                }
            }

            ++this.size;
        } else {
            throw new IndexOutOfBoundsException("index " + index);
        }
    }

    public void set(int index, T value) {
        if ((long)index < this.size && index >= 0) {
            Node<T> temp = this.head;

            for(int i = 0; i < index; ++i) {
                temp = temp.getNext();
            }

            temp.setValue(value);
        } else {
            throw new IndexOutOfBoundsException("index " + index);
        }
    }
}